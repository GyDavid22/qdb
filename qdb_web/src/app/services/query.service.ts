import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Constants } from '../../constants';
import { QuestionMetadata } from '../entities/QuestionMetadata';
import { QuestionMetadataList } from '../entities/QuestionMetadataList';
import { QuestionUpdate } from '../entities/QuestionModify';
import { TagResponse } from '../entities/TagResponse';
import { UserMetadata } from '../entities/UserMetadata';

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

  constructor(private router: Router) { }

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

  public async getQuestionMetadataList(pageNumber: number | undefined = undefined, pageSize: number | undefined = undefined, search: string | undefined = undefined, searchType: "ALL" | "TITLE" | "BODY" | undefined = undefined, tags: string[] | string | undefined = undefined): Promise<QuestionMetadataList> {
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
    let response = await this.queryBase(`question${queryString}`, "GET");
    if (!response.ok) {
      this.router.navigate(["404"]);
    }
    return await (response).json() as QuestionMetadataList;
  }

  public async getQuestionMetadata(id: number): Promise<QuestionMetadata> {
    let response = await this.queryBase(`question/${id}`, "GET");
    if (!response.ok) {
      this.router.navigate(["404"]);
    }
    return await (response).json() as QuestionMetadata;
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
      this.router.navigate(["404"]);
    }
    return await (response).json() as QuestionMetadataList;
  }

  public async getQuestionBody(id: number): Promise<string> {
    let response = await this.queryBase(`question/body/${id}`, "GET");
    if (!response.ok) {
      this.router.navigate(["404"]);
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

  public getCurrentProfilePictureUrl(): string {
    return this.username == "" ? "#" : `${QueryService.BASE_URL}user/picture`;
  }

  public getProfilePictureUrl(username: string): string {
    return this.username == "" ? "#" : `${QueryService.BASE_URL}user/picture/${username}`;
  }

  public getImagePostUrl(): string {
    return `${QueryService.BASE_URL}image`;
  }
}
