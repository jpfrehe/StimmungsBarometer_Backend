package de.fiduciagad.backend.group;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/group")
public class GroupController {
    private final GroupService groupService;
    @Autowired
    public GroupController(GroupService groupService){
        this.groupService = groupService;
    }
    @GetMapping
    public List<Group> getGroups() {
        return groupService.getGroups();
    }
    @PostMapping
    public void addUser(@RequestBody Group group){
        groupService.addGroup(group);

    }

}
