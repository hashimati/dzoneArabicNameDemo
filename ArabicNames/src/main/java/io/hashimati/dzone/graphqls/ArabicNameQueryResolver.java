package io.hashimati.dzone.graphqls;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;
import io.hashimati.dzone.domains.ArabicName;
import io.hashimati.dzone.services.ArabicNameService;
import io.micrometer.core.annotation.Timed;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;


@Singleton
public class ArabicNameQueryResolver implements GraphQLQueryResolver, GraphQLMutationResolver {
    @Inject
    private ArabicNameService arabicNameService;

    

    @Timed(value = "io.hashimati.dzone.graphqls.QueryResolver.save.findById", percentiles = { 0.5, 0.95, 0.99 }, description = "Observing all service metric for finding a arabicName object by id")
    public ArabicName findArabicNameById(long id)
    {
        return arabicNameService.findById(id);
    }

    //@Timed(value = "io.hashimati.dzone.graphqls.ArabicNameQueryResolver.findAll", percentiles = { 0.5, 0.95, 0.99 }, description = "Observing all service metric for finding all arabicName objects")
    public Iterable<ArabicName> findAllArabicName()
    {
        return arabicNameService.findAll();
    }

    @Timed(value = "io.hashimati.dzone.graphqls.ArabicNameQueryResolver.save", percentiles = { 0.5, 0.95, 0.99 }, description = "Observing all service metric for saving arabicName object")
    public ArabicName saveArabicName(ArabicName arabicName){
        return arabicNameService.save(arabicName);
    }

    @Timed(value = "io.hashimati.dzone.graphqls.ArabicNameQueryResolver.update", percentiles = { 0.5, 0.95, 0.99 }, description = "Observing all service metric for update a arabicName object")
    public ArabicName updateArabicName(ArabicName arabicName)
    {
        return  arabicNameService.update(arabicName);

    }

    @Timed(value = "io.hashimati.dzone.graphqls.ArabicNameQueryResolver.deleteById", percentiles = { 0.5, 0.95, 0.99 }, description = "Observing all service metric for deleting a arabicName object by id")
    public boolean deleteArabicName(long id){
      return arabicNameService.deleteById(id);
    }


    @Timed(value = "io.hashimati.dzone.graphqls.QueryResolver.findByIdName", percentiles = { 0.5, 0.95, 0.99 }, description = "Observing all service metric for finding a arabicName object by Name")
    public ArabicName findArabicNameByName(String query){
          return arabicNameService.findByName(query);
    }

    //@Timed(value = "io.hashimati.dzone.graphqls.ArabicNameQueryResolver.findAllLetter", percentiles = { 0.5, 0.95, 0.99 }, description = "Observing all service metric for finding all arabicName objects by Letter")
    public Iterable<ArabicName> findAllArabicNameByLetter(String query){
          return arabicNameService.findAllByLetter(query);
    }

    @Timed(value = "io.hashimati.dzone.graphqls.QueryResolver.findByIdNativeArabic", percentiles = { 0.5, 0.95, 0.99 }, description = "Observing all service metric for finding a arabicName object by NativeArabic")
    public ArabicName findArabicNameByNativeArabic(String query){
          return arabicNameService.findByNativeArabic(query);
    }


}

