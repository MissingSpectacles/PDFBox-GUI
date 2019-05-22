package application.preventSystemExit;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PreventSystemExitSecurityManagerTest {

    @Test
    public void testPreventSystemExit() {
        try {
            System.setSecurityManager(new PreventSystemExitSecurityManager());
            System.exit(0);
        } catch (Exception e) {
            assertThat(e).isInstanceOf(PreventSystemExitException.class);
        }
    }

}