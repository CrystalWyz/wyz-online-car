package cn.wyz.passengeruser.service.impl;

import cn.wyz.insternalcommon.constant.CommonStatusEnum;
import cn.wyz.insternalcommon.exception.AppException;
import cn.wyz.insternalcommon.bean.PassengerUser;
import cn.wyz.passengeruser.mapper.PassengerUserMapper;
import cn.wyz.passengeruser.service.UserService;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author wangnanxiang
 */
@Service
public class UserServiceImpl implements UserService {

    private final PassengerUserMapper userMapper;

    public UserServiceImpl(PassengerUserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public void login(String passengerPhone) {

        // 用户查询
        PassengerUser passengerUser = userMapper.selectOne(Wrappers.lambdaQuery(PassengerUser.class)
                .eq(PassengerUser::getPassengerPhone, passengerPhone));

        if (ObjectUtils.isEmpty(passengerUser)) {
            // 注册
            LocalDateTime localDateTime = LocalDateTime.now();
            passengerUser = PassengerUser.builder()
                    .passengerPhone(passengerPhone)
                    .passengerName("未命名")
                    .passengerGender(Byte.valueOf("1"))
                    .state(Byte.valueOf("0"))
                    .gmtCreate(localDateTime)
                    .gmtModified(localDateTime)
                    .build();
            int insertResult = userMapper.insert(passengerUser);
            if (insertResult <= 0) {
                throw new AppException(CommonStatusEnum.FAIL.getCode(), "用户注册失败");
            }
        }
    }

    @Override
    public PassengerUser getUserInfo(String passengerPhone) {
        PassengerUser passengerUser = userMapper.selectOne(Wrappers.lambdaQuery(PassengerUser.class)
                .eq(PassengerUser::getPassengerPhone, passengerPhone));
        if (ObjectUtils.isEmpty(passengerUser)) {
            throw new AppException(CommonStatusEnum.FAIL.getCode(), "用户不存在");
        }
        return passengerUser;
    }
}
