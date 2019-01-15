package gr.ilias.veloblog.Services;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import gr.ilias.veloblog.Models.Article;

@Stateless
public class ArticleService {
    @PersistenceContext
    private EntityManager em;

    public void persist(Article article) {
        if (article.isPersisted()) {
            em.merge(article);
        } else {
            em.persist(article);
        }
    }

    public void remove(Article article) {
        em.remove(em.contains(article) ? article : em.merge(article));
    }

    public List<Article> findAll() {
        return em.createQuery("select a from Article a").getResultList();
    }

    public Article getArticle(Long id) {
        return em.find(Article.class, id);
    }

    public Article getArticleBySlug(String slug) {
        return em.createQuery("select a from Article a where a.slug = :slug", Article.class)
            .setParameter("slug", slug).getSingleResult();
    }
}
