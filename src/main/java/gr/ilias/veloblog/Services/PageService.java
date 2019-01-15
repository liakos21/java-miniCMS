package gr.ilias.veloblog.Services;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import gr.ilias.veloblog.Models.Page;

@Stateless
public class PageService {
    @PersistenceContext
    private EntityManager em;

    public void persist(Page page) {
        if (page.isPersisted()) {
            em.merge(page);
        } else {
            em.persist(page);
        }
    }

    public void remove(Page page) {
        em.remove(em.contains(page) ? page : em.merge(page));
    }

    public List<Page> findAll() {
        return em.createQuery("select p from Page p").getResultList();
    }

    public Page getPage(Long id) {
        return em.find(Page.class, id);
    }

    public Page getPageBySlug(String slug) {
        return em.createQuery("select p from Page p where p.slug = :slug", Page.class)
            .setParameter("slug", slug).getSingleResult();
    }
}
