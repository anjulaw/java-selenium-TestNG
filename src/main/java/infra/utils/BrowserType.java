package infra.utils;

public enum BrowserType {

    CHROME("Google Chrome", "chrome"),
    CHROME_REMOTE("Google Chrome - Remote", "remote chrome");

    public String name;
    public String shortName;

    BrowserType(String name,String shortName){
        this.name = name;
        this.shortName = shortName;
    }

    public static BrowserType fromString(String str){
        str = str.toLowerCase();

        if(str.equals("chrome")){
            return CHROME;
        }else if(str.equals("chrome-remote")){
            return CHROME_REMOTE;
        }

        return null;
    }
}
