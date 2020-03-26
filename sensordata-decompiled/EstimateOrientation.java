// 
// Decompiled by Procyon v0.5.36
// 

package se.hendeby.sensordata;

import java.io.IOException;

public class EstimateOrientation
{
    private SensorDataReader server_;
    private Thread thread_;
    private double t;
    private boolean doRun_;
    private final double gyroMeasError = 0.08726646259971647;
    private final double gyroMeasDrift = 0.003490658503988659;
    private final double beta;
    private final double zeta;
    private double SEq_1;
    private double SEq_2;
    private double SEq_3;
    private double SEq_4;
    private double b_x;
    private double b_z;
    private double w_bx;
    private double w_by;
    private double w_bz;
    
    public EstimateOrientation(final SensorDataReader server) {
        this.t = -1.0;
        this.doRun_ = true;
        this.beta = Math.sqrt(0.75) * 0.08726646259971647;
        this.zeta = Math.sqrt(0.75) * 0.003490658503988659;
        this.SEq_1 = 1.0;
        this.SEq_2 = 0.0;
        this.SEq_3 = 0.0;
        this.SEq_4 = 0.0;
        this.b_x = 1.0;
        this.b_z = 0.0;
        this.w_bx = 0.0;
        this.w_by = 0.0;
        this.w_bz = 0.0;
        this.server_ = server;
    }
    
    public void start() throws IOException {
        this.server_.start();
        (this.thread_ = new Thread(new Runnable() {
            @Override
            public void run() {
                while (EstimateOrientation.this.doRun_ && EstimateOrientation.this.server_.status()) {
                    final double[][] data = EstimateOrientation.this.server_.getNext(5L);
                    if (!Double.isNaN(data[0][0]) && !Double.isNaN(data[0][1]) && !Double.isNaN(data[0][4])) {
                        if (EstimateOrientation.this.t < 0.0) {
                            EstimateOrientation.this.t = data[0][0];
                        }
                        final double dT = (data[0][0] - EstimateOrientation.this.t) / 1000.0;
                        EstimateOrientation.this.t = data[0][0];
                        if (!Double.isNaN(data[0][7])) {
                            EstimateOrientation.this.MARGUpdate(dT, data[0][4], data[0][5], data[0][6], data[0][1], data[0][2], data[0][3], data[0][7], data[0][8], data[0][9]);
                        }
                        else {
                            EstimateOrientation.this.IMUUpdate(dT, data[0][4], data[0][5], data[0][6], data[0][1], data[0][2], data[0][3]);
                        }
                    }
                }
            }
        })).start();
    }
    
    public boolean status() {
        return this.server_ != null && this.server_.status();
    }
    
    public double[] getQuat() {
        return new double[] { this.SEq_1, this.SEq_2, this.SEq_3, this.SEq_4 };
    }
    
    public void stop() throws IOException {
        this.doRun_ = false;
        try {
            if (this.thread_ != null) {
                this.thread_.join(1000L);
            }
        }
        catch (InterruptedException ex) {}
        if (this.server_ != null) {
            this.server_.stop();
        }
    }
    
    @Override
    protected void finalize() throws Throwable {
        this.stop();
    }
    
    private void IMUUpdate(final double dT, final double w_x, final double w_y, final double w_z, double a_x, double a_y, double a_z) {
        final double halfSEq_1 = 0.5 * this.SEq_1;
        final double halfSEq_2 = 0.5 * this.SEq_2;
        final double halfSEq_3 = 0.5 * this.SEq_3;
        final double halfSEq_4 = 0.5 * this.SEq_4;
        final double twoSEq_1 = 2.0 * this.SEq_1;
        final double twoSEq_2 = 2.0 * this.SEq_2;
        final double twoSEq_3 = 2.0 * this.SEq_3;
        double norm = Math.sqrt(a_x * a_x + a_y * a_y + a_z * a_z);
        a_x /= norm;
        a_y /= norm;
        a_z /= norm;
        final double f_1 = twoSEq_2 * this.SEq_4 - twoSEq_1 * this.SEq_3 - a_x;
        final double f_2 = twoSEq_1 * this.SEq_2 + twoSEq_3 * this.SEq_4 - a_y;
        final double f_3 = 1.0 - twoSEq_2 * this.SEq_2 - twoSEq_3 * this.SEq_3 - a_z;
        final double J_11or24 = twoSEq_3;
        final double J_12or23 = 2.0 * this.SEq_4;
        final double J_13or22 = twoSEq_1;
        final double J_14or21 = twoSEq_2;
        final double J_32 = 2.0 * J_14or21;
        final double J_33 = 2.0 * J_11or24;
        double SEqHatDot_1 = J_14or21 * f_2 - J_11or24 * f_1;
        double SEqHatDot_2 = J_12or23 * f_1 + J_13or22 * f_2 - J_32 * f_3;
        double SEqHatDot_3 = J_12or23 * f_2 - J_33 * f_3 - J_13or22 * f_1;
        double SEqHatDot_4 = J_14or21 * f_1 + J_11or24 * f_2;
        norm = Math.sqrt(SEqHatDot_1 * SEqHatDot_1 + SEqHatDot_2 * SEqHatDot_2 + SEqHatDot_3 * SEqHatDot_3 + SEqHatDot_4 * SEqHatDot_4);
        SEqHatDot_1 /= norm;
        SEqHatDot_2 /= norm;
        SEqHatDot_3 /= norm;
        SEqHatDot_4 /= norm;
        final double SEqDot_omega_1 = -halfSEq_2 * w_x - halfSEq_3 * w_y - halfSEq_4 * w_z;
        final double SEqDot_omega_2 = halfSEq_1 * w_x + halfSEq_3 * w_z - halfSEq_4 * w_y;
        final double SEqDot_omega_3 = halfSEq_1 * w_y - halfSEq_2 * w_z + halfSEq_4 * w_x;
        final double SEqDot_omega_4 = halfSEq_1 * w_z + halfSEq_2 * w_y - halfSEq_3 * w_x;
        this.SEq_1 += (SEqDot_omega_1 - this.beta * SEqHatDot_1) * dT;
        this.SEq_2 += (SEqDot_omega_2 - this.beta * SEqHatDot_2) * dT;
        this.SEq_3 += (SEqDot_omega_3 - this.beta * SEqHatDot_3) * dT;
        this.SEq_4 += (SEqDot_omega_4 - this.beta * SEqHatDot_4) * dT;
        norm = Math.sqrt(this.SEq_1 * this.SEq_1 + this.SEq_2 * this.SEq_2 + this.SEq_3 * this.SEq_3 + this.SEq_4 * this.SEq_4);
        this.SEq_1 /= norm;
        this.SEq_2 /= norm;
        this.SEq_3 /= norm;
        this.SEq_4 /= norm;
    }
    
    private void MARGUpdate(final double dT, double w_x, double w_y, double w_z, double a_x, double a_y, double a_z, double m_x, double m_y, double m_z) {
        final double halfSEq_1 = 0.5 * this.SEq_1;
        final double halfSEq_2 = 0.5 * this.SEq_2;
        final double halfSEq_3 = 0.5 * this.SEq_3;
        final double halfSEq_4 = 0.5 * this.SEq_4;
        final double twoSEq_1 = 2.0 * this.SEq_1;
        final double twoSEq_2 = 2.0 * this.SEq_2;
        final double twoSEq_3 = 2.0 * this.SEq_3;
        final double twoSEq_4 = 2.0 * this.SEq_4;
        final double twob_x = 2.0 * this.b_x;
        final double twob_z = 2.0 * this.b_z;
        final double twob_xSEq_1 = 2.0 * this.b_x * this.SEq_1;
        final double twob_xSEq_2 = 2.0 * this.b_x * this.SEq_2;
        final double twob_xSEq_3 = 2.0 * this.b_x * this.SEq_3;
        final double twob_xSEq_4 = 2.0 * this.b_x * this.SEq_4;
        final double twob_zSEq_1 = 2.0 * this.b_z * this.SEq_1;
        final double twob_zSEq_2 = 2.0 * this.b_z * this.SEq_2;
        final double twob_zSEq_3 = 2.0 * this.b_z * this.SEq_3;
        final double twob_zSEq_4 = 2.0 * this.b_z * this.SEq_4;
        double SEq_1SEq_3 = this.SEq_1 * this.SEq_3;
        double SEq_2SEq_4 = this.SEq_2 * this.SEq_4;
        final double twom_x = 2.0 * m_x;
        final double twom_y = 2.0 * m_y;
        final double twom_z = 2.0 * m_z;
        double norm = Math.sqrt(a_x * a_x + a_y * a_y + a_z * a_z);
        a_x /= norm;
        a_y /= norm;
        a_z /= norm;
        norm = Math.sqrt(m_x * m_x + m_y * m_y + m_z * m_z);
        m_x /= norm;
        m_y /= norm;
        m_z /= norm;
        final double f_1 = twoSEq_2 * this.SEq_4 - twoSEq_1 * this.SEq_3 - a_x;
        final double f_2 = twoSEq_1 * this.SEq_2 + twoSEq_3 * this.SEq_4 - a_y;
        final double f_3 = 1.0 - twoSEq_2 * this.SEq_2 - twoSEq_3 * this.SEq_3 - a_z;
        final double f_4 = twob_x * (0.5 - this.SEq_3 * this.SEq_3 - this.SEq_4 * this.SEq_4) + twob_z * (SEq_2SEq_4 - SEq_1SEq_3) - m_x;
        final double f_5 = twob_x * (this.SEq_2 * this.SEq_3 - this.SEq_1 * this.SEq_4) + twob_z * (this.SEq_1 * this.SEq_2 + this.SEq_3 * this.SEq_4) - m_y;
        final double f_6 = twob_x * (SEq_1SEq_3 + SEq_2SEq_4) + twob_z * (0.5 - this.SEq_2 * this.SEq_2 - this.SEq_3 * this.SEq_3) - m_z;
        final double J_11or24 = twoSEq_3;
        final double J_12or23 = 2.0 * this.SEq_4;
        final double J_13or22 = twoSEq_1;
        final double J_14or21 = twoSEq_2;
        final double J_32 = 2.0 * J_14or21;
        final double J_33 = 2.0 * J_11or24;
        final double J_34 = twob_zSEq_3;
        final double J_35 = twob_zSEq_4;
        final double J_36 = 2.0 * twob_xSEq_3 + twob_zSEq_1;
        final double J_37 = 2.0 * twob_xSEq_4 - twob_zSEq_2;
        final double J_38 = twob_xSEq_4 - twob_zSEq_2;
        final double J_39 = twob_xSEq_3 + twob_zSEq_1;
        final double J_40 = twob_xSEq_2 + twob_zSEq_4;
        final double J_41 = twob_xSEq_1 - twob_zSEq_3;
        final double J_42 = twob_xSEq_3;
        final double J_43 = twob_xSEq_4 - 2.0 * twob_zSEq_2;
        final double J_44 = twob_xSEq_1 - 2.0 * twob_zSEq_3;
        final double J_45 = twob_xSEq_2;
        double SEqHatDot_1 = J_14or21 * f_2 - J_11or24 * f_1 - J_34 * f_4 - J_38 * f_5 + J_42 * f_6;
        double SEqHatDot_2 = J_12or23 * f_1 + J_13or22 * f_2 - J_32 * f_3 + J_35 * f_4 + J_39 * f_5 + J_43 * f_6;
        double SEqHatDot_3 = J_12or23 * f_2 - J_33 * f_3 - J_13or22 * f_1 - J_36 * f_4 + J_40 * f_5 + J_44 * f_6;
        double SEqHatDot_4 = J_14or21 * f_1 + J_11or24 * f_2 - J_37 * f_4 - J_41 * f_5 + J_45 * f_6;
        norm = Math.sqrt(SEqHatDot_1 * SEqHatDot_1 + SEqHatDot_2 * SEqHatDot_2 + SEqHatDot_3 * SEqHatDot_3 + SEqHatDot_4 * SEqHatDot_4);
        SEqHatDot_1 /= norm;
        SEqHatDot_2 /= norm;
        SEqHatDot_3 /= norm;
        SEqHatDot_4 /= norm;
        final double w_err_x = twoSEq_1 * SEqHatDot_2 - twoSEq_2 * SEqHatDot_1 - twoSEq_3 * SEqHatDot_4 + twoSEq_4 * SEqHatDot_3;
        final double w_err_y = twoSEq_1 * SEqHatDot_3 + twoSEq_2 * SEqHatDot_4 - twoSEq_3 * SEqHatDot_1 - twoSEq_4 * SEqHatDot_2;
        final double w_err_z = twoSEq_1 * SEqHatDot_4 - twoSEq_2 * SEqHatDot_3 + twoSEq_3 * SEqHatDot_2 - twoSEq_4 * SEqHatDot_1;
        this.w_bx += w_err_x * dT * this.zeta;
        this.w_by += w_err_y * dT * this.zeta;
        this.w_bz += w_err_z * dT * this.zeta;
        w_x -= this.w_bx;
        w_y -= this.w_by;
        w_z -= this.w_bz;
        final double SEqDot_omega_1 = -halfSEq_2 * w_x - halfSEq_3 * w_y - halfSEq_4 * w_z;
        final double SEqDot_omega_2 = halfSEq_1 * w_x + halfSEq_3 * w_z - halfSEq_4 * w_y;
        final double SEqDot_omega_3 = halfSEq_1 * w_y - halfSEq_2 * w_z + halfSEq_4 * w_x;
        final double SEqDot_omega_4 = halfSEq_1 * w_z + halfSEq_2 * w_y - halfSEq_3 * w_x;
        this.SEq_1 += (SEqDot_omega_1 - this.beta * SEqHatDot_1) * dT;
        this.SEq_2 += (SEqDot_omega_2 - this.beta * SEqHatDot_2) * dT;
        this.SEq_3 += (SEqDot_omega_3 - this.beta * SEqHatDot_3) * dT;
        this.SEq_4 += (SEqDot_omega_4 - this.beta * SEqHatDot_4) * dT;
        norm = Math.sqrt(this.SEq_1 * this.SEq_1 + this.SEq_2 * this.SEq_2 + this.SEq_3 * this.SEq_3 + this.SEq_4 * this.SEq_4);
        this.SEq_1 /= norm;
        this.SEq_2 /= norm;
        this.SEq_3 /= norm;
        this.SEq_4 /= norm;
        final double SEq_1SEq_4 = this.SEq_1 * this.SEq_2;
        SEq_1SEq_3 = this.SEq_1 * this.SEq_3;
        final double SEq_1SEq_5 = this.SEq_1 * this.SEq_4;
        final double SEq_3SEq_4 = this.SEq_3 * this.SEq_4;
        final double SEq_2SEq_5 = this.SEq_2 * this.SEq_3;
        SEq_2SEq_4 = this.SEq_2 * this.SEq_4;
        final double h_x = twom_x * (0.5 - this.SEq_3 * this.SEq_3 - this.SEq_4 * this.SEq_4) + twom_y * (SEq_2SEq_5 - SEq_1SEq_5) + twom_z * (SEq_2SEq_4 + SEq_1SEq_3);
        final double h_y = twom_x * (SEq_2SEq_5 + SEq_1SEq_5) + twom_y * (0.5 - this.SEq_2 * this.SEq_2 - this.SEq_4 * this.SEq_4) + twom_z * (SEq_3SEq_4 - SEq_1SEq_4);
        final double h_z = twom_x * (SEq_2SEq_4 - SEq_1SEq_3) + twom_y * (SEq_3SEq_4 + SEq_1SEq_4) + twom_z * (0.5 - this.SEq_2 * this.SEq_2 - this.SEq_3 * this.SEq_3);
        this.b_x = Math.sqrt(h_x * h_x + h_y * h_y);
        this.b_z = h_z;
    }
}
