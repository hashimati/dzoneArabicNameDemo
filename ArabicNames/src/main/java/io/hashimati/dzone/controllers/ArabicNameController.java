package io.hashimati.dzone.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;




import io.micronaut.context.annotation.Parameter;
import io.micronaut.core.version.annotation.Version;
import io.micronaut.http.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.micrometer.core.annotation.Timed;
import io.micronaut.tracing.annotation.NewSpan;
import io.micronaut.tracing.annotation.SpanTag;
import jakarta.inject.Inject;

import io.hashimati.dzone.domains.ArabicName;
import io.hashimati.dzone.services.ArabicNameService;


@Tag(name = "ArabicName")
@Controller("/api/v1/arabicName")
public class ArabicNameController {

    private static final Logger log = LoggerFactory.getLogger(ArabicNameController.class);

    @Inject private ArabicNameService arabicNameService;


    @NewSpan("ArabicName-service")
    @Timed(value = "io.hashimati.dzone.controllers.arabicNameController.save", percentiles = { 0.5, 0.95, 0.99 }, description = "Observing all service metric for saving arabicName object")
    
    @Post("/save")
    @Version("1")
    @Operation(summary = "Creating a arabicName and Storing in the database",
            description = "A REST service, which saves ArabicName objects to the database.",
            operationId = "SaveArabicName"
    )
    @ApiResponse(
            content = @Content(mediaType = "application/json")
    )
    @ApiResponse(responseCode = "400", description = "Invalid Object Supplied")
    @ApiResponse(responseCode = "404", description = "ArabicName not stored")
    public ArabicName save(@SpanTag("save.arabicName") @Body ArabicName arabicName  ){
        log.info("Saving  ArabicName : {}", arabicName);
        //TODO insert your logic here!

        //saving Object
        return arabicNameService.save(arabicName );
    }


    @NewSpan("ArabicName-service")
    @Timed(value = "io.hashimati.dzone.controllers.arabicNameController.findById", percentiles = { 0.5, 0.95, 0.99 }, description = "Observing all service metric for finding a arabicName object by id")
    
    @Get("/get")
    @Version("1")
    @Operation(summary = "Getting a arabicName by Id",
        description = "A REST service, which retrieves a ArabicName object by Id.",
        operationId = "FindByIdArabicName"
    )
    @ApiResponse(
        content = @Content(mediaType = "application/json")
    )
    @ApiResponse(responseCode = "400", description = "Invalid Id Supplied")
    @ApiResponse(responseCode = "404", description = "ArabicName not found")
    public ArabicName findById(@SpanTag("findById.id") @Parameter("id") long id ){
        return arabicNameService.findById(id );
    }

    @NewSpan("ArabicName-service")
    @Timed(value = "io.hashimati.dzone.controllers.arabicNameController.deleteById", percentiles = { 0.5, 0.95, 0.99 }, description = "Observing all service metric for deleting a arabicName object by id")
    
    @Delete("/delete/{id}")
    @Version("1")
    @Operation(summary = "Deleting a arabicName by ID",
            description = "A REST service, which deletes ArabicName object from the database.",
            operationId = "DeleteByIdArabicName"
    )
    @ApiResponse(
            content = @Content(mediaType = "boolean")
    )
    @ApiResponse(responseCode = "400", description = "Invalid Id Supplied")
    @ApiResponse(responseCode = "404", description = "ArabicName not found")
    public boolean deleteById(@SpanTag("deleteById.id") @PathVariable("id") long id ){
        log.info("Deleting ArabicName by Id: {}", id);
        return  arabicNameService.deleteById(id );
    }

    @NewSpan("ArabicName-service")
    @Timed(value = "io.hashimati.dzone.controllers.arabicNameController.findAll", percentiles = { 0.5, 0.95, 0.99 }, description = "Observing all service metric for finding all arabicName objects")
    
    @Get("/findAll")
    @Version("1")
    @Operation(summary = "Retrieving all arabicName objects as Json",
            description = "A REST service, which returns all ArabicName objects from the database.",
            operationId = "FindAllArabicName"
    )
    @ApiResponse(
            content = @Content(mediaType = "application/json")
    )
    public Iterable<ArabicName> findAll( ){
        log.info("find All");
        return arabicNameService.findAll( );
    }

    @NewSpan("ArabicName-service")
    @Timed(value = "io.hashimati.dzone.controllers.arabicNameController.update", percentiles = { 0.5, 0.95, 0.99 }, description = "Observing all service metric for update a arabicName object")
    
    @Put("/update")
    @Version("1")
    @Operation(summary = "Updating a arabicName.",
            description = "A REST service, which update a ArabicName objects to the database.",
            operationId = "UpdateArabicName"
    )
    @ApiResponse(
            content = @Content(mediaType = "application/json")
    )
    @ApiResponse(responseCode = "404", description = "ArabicName not found")
    public ArabicName update(@SpanTag("update.arabicName") @Body ArabicName arabicName )
    {
        log.info("update {}", arabicName);
        return arabicNameService.update(arabicName );

    }

    
    @Get("/findByName")
    @NewSpan("ArabicName-service")
    @Timed(value = "io.hashimati.dzone.controllers.arabicNameController.findByName", percentiles = { 0.5, 0.95, 0.99 }, description = "Observing all service metric for finding a arabicName object by Name")
    @Operation(summary = "Find an entity by Name",
    description = "A REST service, which retrieves a ArabicName object by Name."
    )
    @ApiResponse(
    content = @Content(mediaType = "application/json")
    )
    @ApiResponse(responseCode = "400", description = "Invalid Id Supplied")
    @ApiResponse(responseCode = "404", description = "ArabicName not found")
    public ArabicName findByName(String query ){
          log.info("Finding ArabicName By Name: {}", query);
          return arabicNameService.findByName(query );
    }


    @NewSpan("ArabicName-service")
    @Timed(value = "io.hashimati.dzone.controllers.arabicNameController.findAllByLetter", percentiles = { 0.5, 0.95, 0.99 }, description = "Observing all service metric for finding a arabicName object by Letter")
    
    @Get("/findAllByLetter")
    @Operation(summary = "Getting all entity by Letter",
       description = "A REST service, which retrieves a ArabicName objects by Letter."
    )
    @ApiResponse(
       content = @Content(mediaType = "application/json")
    )
    @ApiResponse(responseCode = "400", description = "Invalid Id Supplied")
    @ApiResponse(responseCode = "404", description = "ArabicName not found")
    public Iterable<ArabicName> findAllByLetter(String query ){
          log.info("Finding all ArabicName By Letter: {}", query);
          return arabicNameService.findAllByLetter(query );
    }


    
    @Get("/findByNativeArabic")
    @NewSpan("ArabicName-service")
    @Timed(value = "io.hashimati.dzone.controllers.arabicNameController.findByNativeArabic", percentiles = { 0.5, 0.95, 0.99 }, description = "Observing all service metric for finding a arabicName object by NativeArabic")
    @Operation(summary = "Find an entity by NativeArabic",
    description = "A REST service, which retrieves a ArabicName object by NativeArabic."
    )
    @ApiResponse(
    content = @Content(mediaType = "application/json")
    )
    @ApiResponse(responseCode = "400", description = "Invalid Id Supplied")
    @ApiResponse(responseCode = "404", description = "ArabicName not found")
    public ArabicName findByNativeArabic(String query ){
          log.info("Finding ArabicName By NativeArabic: {}", query);
          return arabicNameService.findByNativeArabic(query );
    }



}


