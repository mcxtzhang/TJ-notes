package com.mcxtzhang.Chapter6;

import java.util.*;

import com.mcxtzhang.special.*;
import com.mcxtzhang.special.List;


/**
 * 测试包导入 * ，里面有同名 Vector
 * <p>
 * import java.util.*;
 * import com.mcxtzhang.special.*
 * import com.mcxtzhang.special.List;
 * 虽然java.util 和 com.mcxtzhang.special 里都有List，但是还是以最终特殊指定的为准.
 * <p>
 * <p>
 * <p>
 * Created by Administrator on 2017/2/7.
 */
public class ImportTest {
    public static void main(String[] args) {
        List list = new List();
    }
}
