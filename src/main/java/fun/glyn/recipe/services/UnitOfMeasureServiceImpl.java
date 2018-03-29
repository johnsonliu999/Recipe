package fun.glyn.recipe.services;

import fun.glyn.recipe.commands.UnitOfMeasureCommand;
import fun.glyn.recipe.converters.UnitOfMeasureToUnitOfMeasureCommand;
import fun.glyn.recipe.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UnitOfMeasureServiceImpl implements UnitOfMeasureService {

    private final UnitOfMeasureRepository uomRespository;
    private final UnitOfMeasureToUnitOfMeasureCommand uomConverter;

    public UnitOfMeasureServiceImpl(UnitOfMeasureRepository uomRespository, UnitOfMeasureToUnitOfMeasureCommand uomConverter) {
        this.uomRespository = uomRespository;
        this.uomConverter = uomConverter;
    }

    @Override
    public Set<UnitOfMeasureCommand> listAllUoms() {

        return StreamSupport.stream(uomRespository.findAll().spliterator(), false)
                .map(uomConverter::convert)
                .collect(Collectors.toSet());

    }
}
