import { Injectable, Type } from '@angular/core';
import { AlertComponent } from '../screens/common-elements/alert/alert.component';

@Injectable({
  providedIn: 'root'
})
export class AlertService {
  public alertList: { component: Type<any>, inputs: Record<string, unknown> }[] = [];
  constructor() { }

  public pushAlert(type: "ERROR" | "INFO" | "SUCCESS", message: string) {
    let object = {
      component: AlertComponent,
      inputs: {
        type: type,
        message: message
      }
    };
    this.alertList.push(object);
    setTimeout(() => {
      this.alertList.splice(0, 1);
    }, 10000);
  }
}
