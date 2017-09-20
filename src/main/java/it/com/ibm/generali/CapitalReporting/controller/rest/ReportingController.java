package it.com.ibm.generali.CapitalReporting.controller.rest;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import it.com.ibm.generali.CapitalReporting.CapitalReportingApplication;
import it.com.ibm.generali.CapitalReporting.dto.AliveDTO;
import it.com.ibm.generali.CapitalReporting.dto.ReportAvailabilityReqDTO;
import it.com.ibm.generali.CapitalReporting.dto.ReportAvailabilityRespDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(value = "CapitalReporting")
@RestController
@RequestMapping("/api/v1/capitalreporting")
public class ReportingController
{
    private static Logger logger = LoggerFactory.getLogger(ReportingController.class);

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
    public AliveDTO alive()
    {
        logger.info("Called Alive Service.");
        String version = CapitalReportingApplication.getVersion();
        String message = "Servicing.";
        return new AliveDTO(version, message);
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
        ReportAvailabilityRespDTO responseDTO;
        String message = request.getEnvironmentId() + " " + request.getReportId() + " > " +
                request.getReportFile();
        responseDTO = new ReportAvailabilityRespDTO(true, message);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
