import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Constants } from '../../constants';
import { QuestionMetadataList } from '../entities/QuestionMetadataList';
import { QuestionUpdate } from '../entities/QuestionModify';
import { TagResponse } from '../entities/TagResponse';
import { UserMetadata } from '../entities/UserMetadata';
import { QuestionsWithPaginatingComponent } from '../screens/common-elements/questions-with-paginating/questions-with-paginating.component';
import { AlertService } from './alert.service';

@Injectable({
  providedIn: 'root'
})
export class QueryService {
  private static readonly BASE_URL = `${Constants.WEBPAGE_URL}java/api/`;
  private _isLoggedIn: boolean = false;
  public get isLoggedIn(): boolean {
    return this._isLoggedIn;
  }
  public get username(): string {
    return this._currentUser?.userName ?? "";
  }
  public get rank(): "SUPERUSER" | "ADMIN" | "NORMAL" | "RESTRICTED" | undefined {
    return this._currentUser?.rank ?? undefined;
  }
  private _currentUser: UserMetadata | undefined;
  private set currentUser(val: UserMetadata | undefined) {
    this._currentUser = val;
    this._isLoggedIn = val !== undefined;
  };

  constructor(private router: Router, private aService: AlertService) { }

  private queryBase(url: string, method: "GET" | "POST" | "PUT" | "DELETE", body: string | undefined = undefined): Promise<Response> {
    let res = fetch(`${QueryService.BASE_URL}${url}`, {
      method: method,
      headers: new Headers({
        "Content-Type": "application/json"
      }),
      body: body,
      credentials: "include"
    });
    return res;
  }

  public async login(username: string | undefined = undefined, password: string | undefined = undefined): Promise<Response> {
    let result = (await this.queryBase("session", "POST", JSON.stringify({
      "username": username,
      "password": password
    })));;
    try {
      if (result.status == 200) {
        this.currentUser = await (await this.getCurrentUserMetadata()).json() as UserMetadata;
      } else if (result.status == 401) {
        this.currentUser = undefined;
      }
    } catch { }
    return result;
  }

  public async registration(username: string | undefined = undefined, password: string | undefined = undefined): Promise<Response> {
    return this.queryBase("user", "POST", JSON.stringify({
      "username": username,
      "password": password
    }));
  }

  public logout() {
    this.queryBase("session/logout", "POST");
    this.currentUser = undefined;
  }

  public async tagsWithCounts(): Promise<TagResponse[]> {
    return await (await this.queryBase("tags", "GET")).json() as TagResponse[];
  }

  public async getQuestionMetadataList(pageNumber: number | undefined = undefined, pageSize: number | undefined = undefined, search: string | undefined = undefined, searchType: "ALL" | "TITLE" | "BODY" | undefined = undefined, tags: string[] | string | undefined = undefined, showReportedOnly: boolean | undefined = undefined): Promise<Response> {
    let queryString = "?";
    if (pageNumber || pageNumber === 0) {
      queryString += `&pageNumber=${pageNumber}`;
    }
    if (pageSize) {
      queryString += `&pageSize=${pageSize}`;
    }
    if (search) {
      queryString += `&search=${search}`;
    }
    if (searchType) {
      queryString += `&searchType=${searchType}`;
    }
    if (tags !== undefined) {
      if (typeof tags == "string") {
        queryString += `&tags=${tags}`;
      } else {
        for (let tag of tags) {
          queryString += `&tags=${tag}`;
        }
      }
    }
    if (showReportedOnly !== undefined) {
      queryString += `&reportedOnly=${showReportedOnly}`;
    }
    return this.queryBase(`question${queryString}`, "GET");
  }

  public async getQuestionMetadata(id: number): Promise<Response> {
    return this.queryBase(`question/${id}`, "GET");
  }

  public async getCurrentUserQuestions(pageSize: number | undefined, pageNumber: number) {
    let url: string;
    if (pageSize !== undefined) {
      url = `question?username=${this.username}&pageSize=${pageSize}&pageNumber=${pageNumber}`;
    } else {
      url = `question?username=${this.username}`;
    }
    let response = await this.queryBase(url, "GET");
    if (!response.ok) {
      this.aService.pushAlert("ERROR", await response.text());
      return {
        resultsCount: 0,
        questions: []
      } as QuestionMetadataList;
    }
    return await (response).json() as QuestionMetadataList;
  }

  public async getQuestionBody(id: number): Promise<string> {
    let response = await this.queryBase(`question/body/${id}`, "GET");
    if (!response.ok) {
      this.aService.pushAlert("ERROR", await response.text());
    }
    return await (response).text();
  }

  public async updateExistingQuestion(id: number, updated: QuestionUpdate): Promise<Response> {
    return this.queryBase(`question/${id}`, "PUT", JSON.stringify(updated));
  }

  public async deleteQuestion(id: number): Promise<Response> {
    return this.queryBase(`question/${id}`, "DELETE");
  }

  public async addQuestion(newQuestion: QuestionUpdate): Promise<Response> {
    return this.queryBase(`question`, "POST", JSON.stringify(newQuestion));
  }

  public async randomQuestion(count: number): Promise<Response> {
    return this.queryBase(`question/random?count=${count}`, "GET");
  }

  public async getCurrentUserMetadata(): Promise<Response> {
    return this.queryBase("user", "GET");
  }

  public async getAllUserMetadata(): Promise<Response> {
    return this.queryBase("user/all", "GET");
  }

  public async setCurrentUserPassword(currentPassword: string, newPassword: string): Promise<Response> {
    return this.queryBase("user/password", "POST", JSON.stringify({
      "oldPassword": currentPassword,
      "newPassword": newPassword
    }));
  }

  public async setUserPassword(username: string, newPassword: string): Promise<Response> {
    return this.queryBase(`user/password/${username}`, "POST", JSON.stringify({
      "newPassword": newPassword
    }));
  }

  public async deleteCurrentUser(): Promise<Response> {
    let response = await this.queryBase("user", "DELETE");
    if (response.status == 200) {
      this.currentUser == undefined;
    }
    return response;
  }

  public async deleteUser(username: string): Promise<Response> {
    return this.queryBase(`user/${username}`, "DELETE");
  }

  public setRank(username: string, rank: "SUPERUSER" | "ADMIN" | "NORMAL" | "RESTRICTED"): Promise<Response> {
    return this.queryBase(`user/rank/${username}`, "POST", JSON.stringify({
      rank: rank
    }));
  }

  public resetProfilePicture(): Promise<Response> {
    return this.queryBase("user/picture", "DELETE");
  }

  public async bindImage(imagename: string, questionid: number): Promise<Response> {
    return this.queryBase(`image/${imagename}`, "POST", JSON.stringify({
      "id": questionid
    }));
  }

  public async deleteImage(imagename: string): Promise<Response> {
    return this.queryBase(`image/${imagename}`, "DELETE");
  }

  public async reportQuestion(id: number): Promise<Response> {
    return this.queryBase(`question/report/${id}`, "POST");
  }

  public async unReportQuestion(id: number): Promise<Response> {
    return this.queryBase(`question/unreport/${id}`, "POST");
  }

  public async addToFavorites(id: number): Promise<Response> {
    return this.queryBase(`question/favorite/${id}`, "POST");
  }

  public async removeFromFavorites(id: number): Promise<Response> {
    return this.queryBase(`question/unfavorite/${id}`, "POST");
  }

  public async getFavoritesForCurrentUser(): Promise<Response> {
    return this.queryBase("question/favorites", "GET");
  }

  public async getLog(pageIndex: number | undefined, pageSize: number | undefined): Promise<Response> {
    if (pageIndex === undefined || pageSize === undefined) {
      return this.queryBase("log", "GET");
    }
    return this.queryBase(`log?pageIndex=${pageIndex}&pageSize=${pageSize}`, "GET");
  }

  public async getLeftNeighbor(id: number): Promise<number | undefined> {
    let result = await this.queryBase(`question/${id}/left`, "GET");
    if (result.status == 404) {
      return undefined;
    }
    return parseInt(await result.text());
  }

  public async getRightNeighbor(id: number): Promise<number | undefined> {
    let result = await this.queryBase(`question/${id}/right`, "GET");
    if (result.status == 404) {
      return undefined;
    }
    return parseInt(await result.text());
  }

  public postJson(button: HTMLInputElement) {
    let formdata = new FormData();
    formdata.append("file", button.files?.item(0) as File);
    let xhr = new XMLHttpRequest();
    xhr.open("POST", this.getJsonPostUrl());
    xhr.withCredentials = true;
    xhr.addEventListener("loadend", () => {
      if (xhr.status == 201) {
        this.aService.pushAlert("SUCCESS", "Questions successfully imported");
        QuestionsWithPaginatingComponent.requestUpdateFromInstances();
      } else if (xhr.status == 413) {
        this.aService.pushAlert("ERROR", "Please upload a file smaller than 5MB");
      } else {
        this.aService.pushAlert("ERROR", xhr.responseText);
      }
      button.value = "";
    });
    xhr.send(formdata);
  }

  public getDownloadPdfUrl(ids: number[]): string {
    let base = `${QueryService.BASE_URL}question/pdf?`;
    for (let i of ids) {
      base += `&id=${i}`;
    }
    return base;
  }

  public getCurrentProfilePictureUrl(): string {
    return this.username == "" ? "#" : `${QueryService.BASE_URL}user/picture`;
  }

  public getProfilePictureUrl(username: string): string {
    return this.username == "" ? "#" : `${QueryService.BASE_URL}user/picture/${username}`;
  }

  public getImagePostUrl(): string {
    return `${QueryService.BASE_URL}image`;
  }

  public showCheckboxes(): boolean {
    return this.isLoggedIn && (this.rank === "SUPERUSER" || this.rank === "ADMIN" || this.rank === "NORMAL");
  }

  public getJsonPostUrl(): string {
    return `${QueryService.BASE_URL}question/json`;
  }

  public get hasRightsToCreate(): boolean {
    return this.isLoggedIn && this.rank !== "RESTRICTED";
  }

  public get canUploadJson(): boolean {
    return this.rank === 'SUPERUSER' || this.rank === 'ADMIN';
  }
}
