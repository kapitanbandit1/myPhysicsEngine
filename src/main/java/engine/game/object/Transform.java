package engine.game.object;

public class Transform
{
    private float pozX;
    private float pozY;
    private float pozZ;

    public Transform(float pozX, float pozY, float pozZ)
    {
        this.pozX = pozX;
        this.pozY = pozY;
        this.pozZ = pozZ;
    }

    public void translate(float pozX, float pozY, float pozZ)
    {
        this.pozX += pozX;
        this.pozY += pozY;
        this.pozZ += pozZ;
    }

    public float getPozX(){ return pozX;}
    public float getPozY(){return pozY;}
    public float getPozZ(){return pozZ;}

}
