package wiaci.proj.userservice.feignClient.fallback;

import wiaci.proj.userservice.entity.Group;
import wiaci.proj.userservice.feignClient.GroupClient;

public class GroupClientFallback implements GroupClient {

    @Override
    public Group findById(Long id) {
        return null;
    }

}
