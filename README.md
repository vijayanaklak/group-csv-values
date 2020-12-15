# group-csv-values

This API service is used to group the values read from CSV (source.csv) based on the following conditions

Case 1 : Rowa has Connection

        Col1  Col2
        1     2
        2     3
        3     4
        
        Result : No of Groups = 1
                 Group values = [1,2,3]
                 
Case 2 : Rows does not have Connection

        Col1  Col2
        1     2
        4     3
        5     6
        
        Result : No of Groups = 3
                 Group values = [[1,2],[4,3],[5,6]]
                 
                 
