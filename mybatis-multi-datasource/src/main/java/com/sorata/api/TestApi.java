package com.sorata.api;

import com.sorata.service.CustomTestService;
import com.sorata.service.MasterTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by :  Sorata   2017/6/26 0026 下午 2:00.
 */
@RestController
public class TestApi {

    @Autowired
    private MasterTestService masterTestService;

    @Autowired
    private CustomTestService customTestService;

    /**
     * 测试主库查询
     *
     * @param id
     * @return
     */
    @RequestMapping("/master/select")
    public Object getaster(@RequestParam Integer id) {
        return masterTestService.getM(id);
    }

    /**
     * 测试主库插入
     *
     * @return
     */
    @RequestMapping("/master/insert")
    public Object insertMaster() {
        return masterTestService.instet();
    }

    /**
     * 测试主库事务
     *
     * @return
     */
    @RequestMapping("/master/ex")
    @Transactional
    public Object exMaster() {
        int m = masterTestService.instet();
        int s = 1000 / 0;
        return m;
    }


    /**
     * 测试从库查询
     *
     * @param id
     * @return
     */
    @RequestMapping("/custom/select")
    public Object getcustom(@RequestParam Integer id) {
        return customTestService.getM(id);
    }

    /**
     * 测试从库插入
     *
     * @return
     */
    @RequestMapping("/custom/insert")
    public Object insertCustom() {
        return customTestService.instet();
    }

    /**
     * 测试从库事务   从库这里需要注意的是，在@Transactional注解上需要显示的声明是哪个事务管理
     *
     * @return
     */
    @RequestMapping("/custom/ex")
    @Transactional("customTransactionManager")
    public Object exCustom() {
        int m = customTestService.instet();
        int s = 1000 / 0;
        return m;
    }

}
