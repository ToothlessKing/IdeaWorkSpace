package bean;

/**
 * Created by Administrator on 2016-09-23.
 */
public class help_topic {
    private int help_topic_id;
    private String name;
    private String help_category_id;
    private String description;
    private String example;
    private String url;

    public help_topic() {
    }

    public int getHelp_topic_id() {
        return help_topic_id;
    }

    public void setHelp_topic_id(int help_topic_id) {
        this.help_topic_id = help_topic_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHelp_category_id() {
        return help_category_id;
    }

    public void setHelp_category_id(String help_category_id) {
        this.help_category_id = help_category_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "help_topic{" +
                "help_topic_id=" + help_topic_id +
                ", name='" + name + '\'' +
                ", help_category_id='" + help_category_id + '\'' +
                ", description='" + description + '\'' +
                ", example='" + example + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
