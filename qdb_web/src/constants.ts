import { environment } from "./environments/environment";

export class Constants {
    public static WEBPAGE_URL: string = "";
    static {
        if (environment.production) {
            Constants.WEBPAGE_URL = "http://157.230.28.235/";
        } else {
            Constants.WEBPAGE_URL = "http://localhost:8080/";
        }
    }
}