/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.harry.Servlet;

import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.harry.Entity.EventsEntity;
import ru.harry.Entity.ServiceEntity;

import java.util.List;

/**
 *
 * @author Harry PC
 */
@Controller
public class EventController {

    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/list")
    public String list(Model model) {
        final Session session = HibernateUtil.getSession();
        session.beginTransaction();
        List<EventsEntity> list = session.createQuery("from ru.harry.Entity.EventsEntity").list();
        List<ServiceEntity> list2 = session.createQuery("from ru.harry.Entity.ServiceEntity").list();
        List<ServiceEntity> list3 = session.createQuery("from ru.harry.Entity.UsersEntity").list();
        List<ServiceEntity> list4 = session.createQuery("from ru.harry.Entity.StatusEntity").list();
        session.getTransaction().commit();
        model.addAttribute("listEvents", list);
        model.addAttribute("listService", list2);
        model.addAttribute("listUsers", list3);
        model.addAttribute("listStatus", list4);
        return "list";
    }


    /*@RequestMapping(value = "/insert")
    public String insert(Model model) {
        return "insert";
    }
    @RequestMapping(value = "/insert/apply")
    public String insert(Model model, AuthorModel am) {
        dao.insert(am);
        return "redirect:/list";
    }

    @RequestMapping(value = "/setAI")
    public String setAI(Model model) { return "setAI"; }
    @RequestMapping(value = "/setAI/apply")
    public String setAI(Model model, AuthorModel am) {
        dao.autoIncrement(am);
        return "redirect:/list";
    }

    @RequestMapping(value = "/edit/{id}")
    public String edit(Model model, @PathVariable String id) {
        final AuthorModel am = dao.selectID(Integer.parseInt(id));
        model.addAttribute("author", am);
        return "insert";    }
    @RequestMapping(value = "/edit/apply", method = RequestMethod.POST)
    public String edit(Model model, AuthorModel am) {
        dao.update(am);
        return "redirect:/list";
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(Model model, @PathVariable String id) {
        final AuthorModel am = dao.selectID(Integer.parseInt(id));
        dao.delete(am); list(model);
        return "redirect:/list";
    }*/

}
