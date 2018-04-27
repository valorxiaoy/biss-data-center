package com.iyungu.annotation;

/**
 * @Author: yueyang@iyungu.com
 * @Description:
 * @Date: Created in 16:11 2018/4/18
 * @Modified By:
 */
@RestController
public class MoonService {

    @RequestMapping(value = "test3")
    public void test3(Object[] id) {
        System.out.println("MoonService->test3(); id = " + id[0]);
    }

    @RequestMapping(id = true, name = "test4", description = "测试方法4", value = "test4")
    public boolean test4(String mm, String aa, String abc, String cbd, String bb) {
        System.out.println("MoonService->test4(String aa, String bb); params: aa = " + aa + ", bb = " + bb + ", mm = " + mm);
        return true;
    }
}