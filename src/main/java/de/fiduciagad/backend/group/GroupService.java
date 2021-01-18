package de.fiduciagad.backend.group;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {
    private final GroupRepository groupRepository;
    @Autowired
    public GroupService(GroupRepository groupRepository){
        this.groupRepository = groupRepository;
    }
    public void addGroup(Group group){
        groupRepository.save(group);
    }
    public List<Group> getGroups(){
        return groupRepository.findAll();
    }

}
