CREATE OR REPLACE VIEW V_Films AS
    SELECT 
        Films.*,
        Statut.nom as statut
    FROM
        Films JOIN Statut ON Films.idStatut = Statut.idStatut
;

CREATE OR REPLACE VIEW V_Scene AS 
    SELECT 
        Scene.*,
        Films.nom as nomfilm,
        Plateau.nom as nomplateau
    FROM 
        Scene JOIN Films ON Scene.idFilms=Films.idFilms 
        JOIN Plateau ON Plateau.idPlateau=Scene.idPlateau
    ORDER BY Scene.idScene;
;


CREATE OR REPLACE VIEW V_Scenario AS 
    SELECT 
        Scenario.*,Scene.idFilms,
        Type.nom as nomtype
    FROM 
        Scenario JOIN Type ON Type.idType=Scenario.idType
        JOIN Scene ON Scene.idScene=Scenario.idScene
    ORDER BY Scenario.idScenario
;

CREATE OR REPLACE VIEW V_Action AS 
    SELECT
        Action.*,
        Personnage.nom 
    FROM 
        Action JOIN Personnage
        ON Personnage.idPersonnage=Action.idPersonnage
;

CREATE OR REPLACE VIEW V_Dialogue AS 
    SELECT 
        Dialogue.*,
        Personnage.nom 
    FROM 
        Dialogue JOIN Personnage ON Personnage.idPersonnage=Dialogue.idPersonnage
;