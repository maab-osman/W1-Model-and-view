package fi.haagahelia.friendslist.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import fi.haagahelia.friendslist.domain.Friend;


@Controller
public class FriendController {
    private List<Friend> friends = new ArrayList<>();

    public FriendController() {
        friends.add(new Friend("Maab", "Osman"));
        friends.add(new Friend("John", "Doe"));
        friends.add(new Friend("Jane", "Smith"));
    }

    @GetMapping("/friends")
    public String listFriends(Model model) {
        model.addAttribute("friends", friends);
        return "friends";
    }
    @GetMapping("/add")
    public String addFriendForm(Model model) {
        model.addAttribute("friend", new Friend());
        return "addFriend";
    }

    @PostMapping("/add")
    public String saveFriend(@ModelAttribute Friend friend) {
        friends.add(friend);
        return "redirect:/friends";
    }

}
