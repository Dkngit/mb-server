package com.example.mbserver.web;

import com.example.mbserver.dao.TeamPageRepository;
import com.example.mbserver.entity.Team;
import com.example.mbserver.pojo.MBPageRequest;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @since 2019/12/8
 */
@Controller
@RequestMapping("api/team")
public class TeamController {

    @Resource
    private TeamPageRepository pageRepository;

    @RequestMapping("list")
    public Page<Team> list(@RequestBody MBPageRequest pageR) {
        return pageRepository.findAll(pageR.pageable());
    }

    @RequestMapping("save")
    public void save(@RequestBody Team team) {
        pageRepository.save(team);
    }
}
