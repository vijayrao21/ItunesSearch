package libraries;

public enum APIEndPoints {
    SearchItunesAPI("/search"),
    LookupItunesAPI("/lookup"),;

    private final String resource;

    APIEndPoints(String resource) {
        this.resource = resource;
    }

    public String getResource() {
        return resource;
    }
}
