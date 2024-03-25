package Homework_Activities.demo.Controller;

import Homework_Activities.demo.Entity.Activity;
import Homework_Activities.demo.Enum.CategoryActivities;
import Homework_Activities.demo.Repository.ActivityRepository;
import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@Controller
public class ActivityController {

    @Autowired
    private ActivityRepository activityRepository;

    @ModelAttribute("categories")
    public List<CategoryActivities> getCategoriesActivities(){
        return Arrays.asList(CategoryActivities.values());
    }

    @PreAuthorize("ADMIN")
    @GetMapping("/activities/create")
    public String createActivity(Model model){
        model.addAttribute("activity", new Activity());
        model.addAttribute("category", CategoryActivities.values());
        return "create-activity";
    }


    @PostMapping("/activities/create")
    public String createPostActivity(@Valid @ModelAttribute Activity activity){

        System.out.println("...");

        activityRepository.save(activity);
        return "redirect:/user-details";
    }



}
