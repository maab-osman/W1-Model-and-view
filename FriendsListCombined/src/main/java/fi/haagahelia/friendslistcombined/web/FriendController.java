package fi.haagahelia.friendslistcombined.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import fi.haagahelia.friendslistcombined.domain.Friend;

@Controller
public class FriendController {

    private List<Friend> friends = new ArrayList<>();

    public FriendController() {
        friends.add(new Friend("Maab", "Osman"));
        friends.add(new Friend("Jane", "Doe"));
        friends.add(new Friend("Jukka", "Juslin"));
    }

    @GetMapping("/friends")
    public String showFriendPage(Model model) {
        model.addAttribute("friends", friends);
        model.addAttribute("friend", new Friend());
        return "friends";
    }

    @PostMapping("/friends")
    public String addFriend(@ModelAttribute Friend friend, Model model) {
        friends.add(friend);
        model.addAttribute("friends", friends);
        model.addAttribute("friend", new Friend());
        return "friends";
    }

}
