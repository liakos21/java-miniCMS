package gr.ilias.veloblog.Models;

import javax.persistence.Entity;
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
}
