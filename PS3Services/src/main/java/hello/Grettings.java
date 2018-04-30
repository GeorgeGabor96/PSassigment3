package hello;

public class Grettings {
    private final long id;
    private final String content;

    public Grettings(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
