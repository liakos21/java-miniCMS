package gr.ilias.veloblog.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Article", uniqueConstraints = {@UniqueConstraint(columnNames = {"slug"})})
public class Article extends Base {

    @Getter @Setter
    private String title;
    @Getter @Setter
    private String slug;
    @Getter @Setter
    private String content;

    public Article() { }

    public Article(String title, String slug, String content) {
        this.title = title;
        this.slug = slug;
        this.content = content;
    }
}
