package nb.fr.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import nb.fr.web.rest.TestUtil;

public class ApplicationUserTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(ApplicationUser.class);
        ApplicationUser applicationUser1 = new ApplicationUser();
        applicationUser1.setId(1L);
        ApplicationUser applicationUser2 = new ApplicationUser();
        applicationUser2.setId(applicationUser1.getId());
        assertThat(applicationUser1).isEqualTo(applicationUser2);
        applicationUser2.setId(2L);
        assertThat(applicationUser1).isNotEqualTo(applicationUser2);
        applicationUser1.setId(null);
        assertThat(applicationUser1).isNotEqualTo(applicationUser2);
    }
}
