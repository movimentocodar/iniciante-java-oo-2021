import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.ArrayList;

public class TestRunner {
    public static void main(String[] args) {
        ArrayList<Result> resultList = new ArrayList<Result>();
        resultList.add(JUnitCore.runClasses(MaquinaDeCafeTest.class));
        resultList.add(JUnitCore.runClasses(CupomTest.class));
        resultList.add(JUnitCore.runClasses(PagamentoTest.class));
        resultList.add(JUnitCore.runClasses(ReservatorioDeAguaTest.class));

        for (Result result : resultList) {
            for (Failure failure : result.getFailures()) {
                System.out.println(failure.toString());
            }

            System.out.println(result.wasSuccessful());
        }
    }
}

