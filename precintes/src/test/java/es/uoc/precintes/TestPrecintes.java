package es.uoc.precintes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import es.uoc.precintes.dto.PrecinteDto;
import es.uoc.precintes.service.PrecintesService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = PrecintesApp.class)
public class TestPrecintes {
	@Autowired
	PrecintesService precService;

	@Test
	public void test() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date datdespre = null;
		Date datfipre = null;
		try {
			datdespre = sdf.parse("01/02/2000");
			datfipre = sdf.parse("01/05/2016");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		Date datdesdespre = null;
		Date datfidespre = null;
		String entitatId = "JUDI";
		String concepteId = null;
		String motiuId = null;
		List<PrecinteDto> precintes = precService.findPrecintesByCriteris(datdespre, datfipre, datdesdespre,
				datfidespre, entitatId, concepteId, motiuId);
		precintes.forEach(e -> System.out.println(e));
		assert (precintes.size() > 0);
	}

}
