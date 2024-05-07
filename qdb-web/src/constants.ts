import { environment } from "./environments/environment";

export class Constants {
    public static WEBPAGE_URL: string = "";
    public static BASE_HREF: string = "";
    static {
        if (environment.production) {
            Constants.WEBPAGE_URL = "http://157.230.28.235/";
            Constants.BASE_HREF = "/java/";
        } else {
            Constants.WEBPAGE_URL = "http://localhost:8080/";
            Constants.BASE_HREF = "";
        }
    }
}