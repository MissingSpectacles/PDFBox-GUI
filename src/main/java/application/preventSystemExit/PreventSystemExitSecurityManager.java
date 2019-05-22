package application.preventSystemExit;

import java.security.Permission;

public class PreventSystemExitSecurityManager extends SecurityManager {

    @Override
    public void checkPermission(Permission perm) {
        if ("exitVM".equals(perm.getName())
                || "exitVM.*".equals(perm.getName())
                || "exitVM.0".equals(perm.getName())) {
            throw new PreventSystemExitException();
        }
    }

}
