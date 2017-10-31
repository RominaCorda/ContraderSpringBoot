package it.com.ibm.generali.capitalreporting.controller.rest;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import it.com.ibm.generali.capitalreporting.CapitalReportingApplication;
import it.com.ibm.generali.capitalreporting.dto.AliveDTO;
import it.com.ibm.generali.capitalreporting.dto.ReportAvailabilityReqDTO;
import it.com.ibm.generali.capitalreporting.dto.ReportAvailabilityRespDTO;
import it.com.ibm.generali.capitalreporting.dto.SquareRespDTO;
import it.com.ibm.generali.capitalreporting.service.Availability;
import it.com.ibm.generali.capitalreporting.service.INumberCruncher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(value = "CapitalReporting")
@RestController
@RequestMapping("/api/v1/capitalreporting")
public class ReportingController
{
    private static Logger logger = LoggerFactory.getLogger(ReportingController.class);
    private Availability availability;
    private INumberCruncher numberCruncher;

    @Autowired
    public ReportingController(Availability availability,
                               INumberCruncher nc)
    {
        Assert.notNull(availability, "Availability is NULL");
        this.availability = availability;
        this.numberCruncher = nc;
    }

    /**
     * Check service
     *
     * @return an AliveDTO instance cointaining info about the service
     */
    @ApiOperation(value = "Alive", notes = "Get information about service.", response = AliveDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "API is alive.", response = AliveDTO.class),
            @ApiResponse(code = 403, message = "Invalid session."),
            @ApiResponse(code = 503, message = "Service unavailable")

    })
    @RequestMapping(value = "/alive", method = RequestMethod.GET)
    @CrossOrigin
    public AliveDTO alive()
    {
        logger.info("Called Alive Service.");
        String version = CapitalReportingApplication.getVersion();
        String message = "Servicing.";
        return new AliveDTO(version, message);
    }

    /**
     * Service square
     *
     * @param number to be squared
     * @return square of input param
     */
    @ApiOperation(value = "Square", notes = "Square the number.", response = SquareRespDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Square returned.", response = SquareRespDTO.class),
            @ApiResponse(code = 403, message = "Invalid session."),
            @ApiResponse(code = 503, message = "Service unavailable")

    })
    @RequestMapping(value = "/square", method = RequestMethod.GET, params = {"number"})
    @CrossOrigin
    public SquareRespDTO getSquare(@RequestParam("number") int number)
    {
        logger.info("Called Square Service.");
        int response = this.numberCruncher.square(number);
        SquareRespDTO srp = new SquareRespDTO();
        srp.setMessage("Ok, the square of " + String.valueOf(number) + " is " + String.valueOf(response));
        srp.setSquare(response);
        return srp;
    }

    /**
     * Check report availability
     *
     * @return an object with the report status results
     */
    @ApiOperation(value = "Check CapitalReporting Report availability",
            notes = "Check if the given report is available.", response = ReportAvailabilityRespDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK, report available.", response = ReportAvailabilityRespDTO.class),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 503, message = "Service unavailable")

    })
    @RequestMapping(value = "/ckreportavail", method = RequestMethod.POST)
    @CrossOrigin
    public ResponseEntity<ReportAvailabilityRespDTO> checkAvailable(
            @Valid @RequestBody ReportAvailabilityReqDTO request)
    {
        ReportAvailabilityRespDTO responseDTO = this.availability.checkAvailable(request);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
