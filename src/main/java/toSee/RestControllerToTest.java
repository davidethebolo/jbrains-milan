public class RestControllerToTest
{



  private Service service;

  public RestControllerToTest(Service service)
  {
    this.service = service;
  }

  @RequestMapping(value = "/someurl", method = POST, produces = { "application/json"})
  public ResponseEntity
  create(@RequestBody Request request, HttpServletResponse response)
  {
    try
    {
      Execution deployResponse = service.execute(request.toDomain());
      return new ResponseEntity(deployResponse, HttpStatus.OK);
    }
    catch (NotFoundException e)
    {
      return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
    }
    catch (Exception e)
    {
      return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
