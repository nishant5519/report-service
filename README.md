# report-service

How to run the project:

Change the input file location in GenerateReport file :
    
    private static final String INPUT_FILE_LOCATION = "/Users/nissing3/Desktop/input.txt";
    
    Change this loation as per your local machine where input file is present containing below data:
    
    2343225,2345,us_east,RedTeam,ProjectApple,3445s
    1223456,2345,us_west,BlueTeam,ProjectBanana,2211s
    3244332,2346,eu_west,YellowTeam3,ProjectCarrot,4322s
    1233456,2345,us_west,BlueTeam,ProjectDate,2221s
    3244132,2346,eu_west,YellowTeam3,ProjectEgg,4122s
    
    The current implementation expects the input in terms of text file. This can further be extended to read from excel/pdf or any other formats.
