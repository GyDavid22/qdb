import { Injectable } from '@angular/core';
import { Constants } from '../../constants';
import { LoginResponse } from '../entities/LoginResponse';
import { Router } from '@angular/router';
import { TagResponse } from '../entities/TagResponse';
import { QuestionMetadata } from '../entities/QuestionMetadata';
import { QuestionMetadataList } from '../entities/QuestionMetadataList';

@Injectable({
  providedIn: 'root'
})
export class QueryService {
  private static readonly BASE_URL = `${Constants.WEBPAGE_URL}java/api/`;
  private _isLoggedIn: boolean = false;
  set isLoggedIn(value: boolean) {
    this._isLoggedIn = value;
  }
  public get isLoggedIn(): boolean {
    return this._isLoggedIn;
  }
  private _username: string = "";
  public get username(): string {
    return this._username;
  }

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
    res.then((value) => {
      if (value.status == 401) {
        this.isLoggedIn = false;
      }
    });
    return res;
  }

  public async login(username: string | undefined = undefined, password: string | undefined = undefined): Promise<boolean> {
    try {
      let result = (await this.queryBase("session", "POST", JSON.stringify({
        "username": username,
        "password": password
      })));
      if (result.status == 200) {
        this.isLoggedIn = true;
        result.json().then((value) => {
          this._username = (value as LoginResponse).username;
        })
        return true;
      }
    } catch (e) { }
    return false;
  }

  public logout() {
    this.queryBase("session/logout", "POST").then((value) => {
      if (value.status == 200) {
        this.isLoggedIn = false;
        this._username = "";
      }
    });
  }

  public async tagsWithCounts(): Promise<TagResponse[]> {
    return await (await this.queryBase("tags", "GET")).json() as TagResponse[];
  }

  public async getQuestionMetadataList(pageNumber: number | undefined = undefined, pageSize: number | undefined = undefined, search: string | undefined = undefined, searchType: "ALL" | "TITLE" | "BODY" | undefined = undefined, tags: string[] | undefined = undefined): Promise<QuestionMetadataList> {
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
      for (let tag of tags) {
        queryString += `&tags=${tag}`;
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

  public async getQuestionBody(id: number): Promise<string> {
    let response = await this.queryBase(`question/body/${id}`, "GET");
    if (!response.ok) {
      this.router.navigate(["404"]);
    }
    return await (response).text();
  }
}
