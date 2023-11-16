package com.example.demo.models;

import java.util.List;

public class ChartDataDTO {
    private List<String> labels;
    private List<ChartDataItemDTO> datasets;

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    public List<ChartDataItemDTO> getDatasets() {
        return datasets;
    }

    public void setDatasets(List<ChartDataItemDTO> datasets) {
        this.datasets = datasets;
    }

}
