package org.f1soft.currentissue.repository;

import org.f1soft.currentissue.model.Issue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class IssueRepositoryTest {
    @Autowired
    private IssueRepository issueRepository;

    @Test
    public void IssueRepository_findAll_Return_All_Issues(){
        Issue issue = Issue.builder()
                .id("1")
                .name("Issue 1")
                .description("Description 1")
                .build();
        Issue issue1 = Issue.builder()
                .id("2")
                .name("Issue 1")
                .description("Description 1")
                .build();

        issueRepository.save(issue);
        issueRepository.save(issue1);

        List<Issue> issues = issueRepository.findAll();

        assertThat(issues).isNotNull();
        assertThat(issues.size()).isEqualTo(2);
    }
}
