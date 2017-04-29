package es.uoc.precintes.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;

import es.uoc.precintes.jpa.PrecinteRepository;
import es.uoc.precintes.model.Precinte;
import es.uoc.precintes.model.QPrecinte;

@Component
public class PrecintesDao {
	@Autowired
	private PrecinteRepository precinteRepository;
	@Autowired
	private EntityManager entityManager;

	public List<Precinte> findPrecintesByCriteris(Date datdespre, Date datfipre, Date datdesdespre, Date datfidespre,
			String entitatId, String concepteId, String motiuId) {
		// 1ª opción -> nombre de método complejo en el repositorio -> no
		// 2ª opción -> HQL -> consulta dentro de un string, no se compila!
		// List<Article> arts = entityManager.createQuery("from Articles where
		// ....");
		// 3ª opción -> QueryDSL -> permite que el compilador nos ayude a
		// escribir HQL.
		QPrecinte precinte = QPrecinte.precinte;
		// 2 Creació de la consulta
		JPAQuery<Precinte> query = new JPAQuery<>(entityManager);
		query.from(precinte);
		BooleanBuilder builder = new BooleanBuilder();
		if (datdespre != null && datfipre != null) {
			builder.or(precinte.datpre.between(datdespre, datfipre));
		}
		if (datdesdespre != null && datfidespre != null) {
			builder.and(precinte.datdes.between(datdespre, datfipre));
		}
		if (entitatId != null) {
			builder.and(precinte.entitat.id.eq(entitatId));
		}
		if (concepteId != null) {
			builder.and(precinte.concepte.id.id.eq(concepteId));
		}
		if (motiuId != null) {
			builder.and(precinte.motiu.id.eq(motiuId));
		}
		query.where(builder);
		query.orderBy(precinte.datpre.asc());
		List<Precinte> list = query.fetch();
		return list;
	}

	public List<Precinte> findPrecintesByCriteris(String criteris) {
		List<Precinte> precintes = null;
		return precintes;
	}

	public List<Precinte> findPrecintesByVehicleId(Long idVehicle) {
		List<Precinte> precintes = precinteRepository.findByVehicleId(idVehicle);
		return precintes;
	}

	public void savePrecinte(Precinte precinte) {
		if (precinte != null) {
			precinteRepository.save(precinte);
		}
	}

	public Precinte getPrecinte(Long precinteId) {
		if (precinteId != null) {
			return precinteRepository.findOne(precinteId);
		}
		return null;
	}

	public long getNumPrecintesVigents(Long idVehicle) {
		QPrecinte precinte = QPrecinte.precinte;
		JPAQuery<Precinte> query = new JPAQuery<>(entityManager);
		BooleanExpression precinteVigent=precinte.datdes.isNull().and(precinte.motiu.isNull());
		query.from(precinte);
		query.where(precinte.vehicleId.eq(idVehicle).and(precinteVigent));
		return query.fetchCount();
	}

}
