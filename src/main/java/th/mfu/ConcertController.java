package th.mfu;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ConcertController {
    // TODO: create hashmap of concerts for storing data
    HashMap<Integer,String> Concert=new HashMap<Integer,String>();//Creating HashMap

    //TODO: add initbinder to convert date
    public final void initBinderUsuariosFormValidator(final WebDataBinder binder, final Locale locale) {
        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", locale);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
    @GetMapping("/concerts")
    public String listConcerts(Model model) {
        // TODO: add concerts to model
        // TODO: return a template to list concerts
        model.addAttribute("concerts", concert.values());
        return "list-concerts";    
    }

    @GetMapping("/add-concert")
    public String addAConcertForm(Model model) {
        // TODO: pass blank concert to a form
        // TODO: return a template for concert form
        
        model.addAttribute("concert", new Concert());
        return "add-concert-form";
    }

    @PostMapping("/concerts")
    public String saveConcert(@ModelAttribute Concert concert) {
        // TODO: add concert to list of concerts
        // TODO: increment nextId
        // TODO: redirect to list concerts

        concert.setId(nextId);
        concerts.put(concert.getId(), concert);
        nextId++;
        return "redirect:/concerts";
        
    }

    @GetMapping("/delete-concert/{id}")
    public String deleteConcert(@PathVariable int id) {
        // TODO: remove concert from list of concerts
        // TODO: redirect to list concerts

        concerts.remove(id);
        return "redirect:/concerts";
    }

    
    @GetMapping("/delete-concert")
    public String removeAllConcerts() {
        //TODO: clear all employees and reset id
        // TODO: redirect to list concerts

        concerts.clear();
        nextId = 1; 
        return "redirect:/concerts";
    }

}
