package task_1;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CatInfo {
    private final String id;
    private final String text;
    private final String type;
    private final String user;
    private final Integer upvotes;

    public CatInfo(@JsonProperty("id") String id, @JsonProperty("text") String text,
                   @JsonProperty("type") String type, @JsonProperty("user") String user,
                   @JsonProperty("upvotes") Integer upvotes) {
        this.id = id;
        this.text = text;
        this.type = type;
        this.user = user;
        this.upvotes = upvotes;
    }

    public String getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getType() {
        return type;
    }

    public String getUser() {
        return user;
    }

    public Integer getUpvotes() {
        return upvotes;
    }

    @Override
    public String toString() {
        return "CatInfo{"
                + "id='" + id + '\''
                + ", text='" + text + '\''
                + ", type='" + type + '\''
                + ", user='" + user + '\''
                + ", upvotes=" + upvotes
                + '}';
    }
}