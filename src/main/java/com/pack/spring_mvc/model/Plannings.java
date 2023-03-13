package com.pack.spring_mvc.model;

public class Plannings {
    private int idjour;
    private int tempstravail;
    private V_Scenario[]  scenario;

    public Plannings() {
    }

    public Plannings(int idjour, int tempstravail, V_Scenario[] scenario) {
        this.idjour = idjour;
        this.tempstravail = tempstravail;
        this.scenario = scenario;
    }

    public int getIdjour() {
        return idjour;
    }

    public void setIdjour(int idjour) {
        this.idjour = idjour;
    }

    public int getTempstravail() {
        return tempstravail;
    }

    public void setTempstravail(int tempstravail) {
        this.tempstravail = tempstravail;
    }

    public V_Scenario[] getScenario() {
        return scenario;
    }

    public void setScenario(V_Scenario[] scenario) {
        this.scenario = scenario;
    }
}
