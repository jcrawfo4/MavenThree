import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

class TestDemoJUnitTest {
    private TestDemo testDemo;

    @BeforeEach
    void setUp() {
        testDemo = new TestDemo();
    }

    private static Stream<Arguments> argumentsForAddPositive() {
        return Stream.of(
                Arguments.arguments(1, 2, 3, false),
                Arguments.arguments(5, 7, 12, false),
                Arguments.arguments(0, 0, 0, true),
                Arguments.arguments(9,9, 18, false),
                Arguments.arguments(-5, 5, 0, true),
                Arguments.arguments(8, 8, 16, false)
        );
    }

    @ParameterizedTest
    @MethodSource("argumentsForAddPositive")
    void assertThatPairsOfPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectedException) {
        if (expectedException) {
            assertThatThrownBy(() ->
                    testDemo.addPositive(a, b))
                    .isInstanceOf(IllegalArgumentException.class);
        }
        else {
            assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
        }

    }
    @Test
    public void assertThatRandomNumberSquaredIsCorrect() {
        TestDemo mockDemo = spy(testDemo);
        doReturn(5).when(mockDemo).getRandomInt();
        int fiveSquared = mockDemo.randomNumberSquared(5);
        assertThat(fiveSquared).isEqualTo(25);
        assertThatThrownBy(() ->
                testDemo.randomNumberSquared(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @AfterEach
    void tearDown() {
    }
}