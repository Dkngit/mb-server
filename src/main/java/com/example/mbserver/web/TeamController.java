package com.example.mbserver.web;

import com.example.mbserver.dao.TeamPageRepository;
import com.example.mbserver.entity.Team;
import com.example.mbserver.pojo.MBPageRequest;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.security.Principal;
import java.util.Date;

/**
 * @since 2019/12/8
 */
@RestController
@RequestMapping("api/team")
public class TeamController {

    @Resource
    private TeamPageRepository pageRepository;

    @RequestMapping("list")
    public Page<Team> list(@RequestBody MBPageRequest pageR) {
        return pageRepository.findAll(pageR.pageable());
    }

    @RequestMapping("save")
    public void save(@RequestBody Team team, Principal principal) {
        Date now = new Date();
        String name = principal.getName();
        if (team.getId() == 0) {
            team.setCreateOn(now);
            team.setCreateBy(name);
        } else {
            team.setModifyOn(now);
            team.setModifyBy(name);
        }
        pageRepository.save(team);
    }

    @RequestMapping("delete")
    public void delete(@RequestBody Team team) {
        pageRepository.deleteById(team.getId());
    }
}
