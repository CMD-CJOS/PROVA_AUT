import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.java.steps",
        plugin = {"pretty", "html:target/cucumber-reports.html"},
//        tags = "@validarCriacaoProdutoSerum",
//        tags = "@validarCriacaoProdutoMascaraLash"
//        tags = "@validarCriacaoProdutoCucumber"
snippets = CucumberOptions.SnippetType.CAMELCASE

        )
public class ProdutoRunnerTest {
}