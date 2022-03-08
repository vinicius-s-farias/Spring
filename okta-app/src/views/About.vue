<template>
  <div id="chart-demo " class="bg-green-50 mx-4">
    <DxChart
      id="zoomedChart"
      :data-source="dataSource"
      title="Solin-Vest Stock Prices "
    >
      <DxSeries
        type="candlestick"
        open-value-field="open"
        high-value-field="max"
        low-value-field="min"
        close-value-field="close"
        argument-field="created_on"
      >
        <DxAggregation :enabled="true" />
      </DxSeries>
      <DxArgumentAxis
        :visual-range="visualRange"
        :value-margins-enabled="false"
        argument-type="datetime"
      >
        <DxGrid :visible="true" />
        <DxLabel :visible="false" />
      </DxArgumentAxis>
      <DxValueAxis value-type="numeric" />
      <DxMargin :right="10" />
      <DxLegend :visible="false" />
      <DxTooltip :enabled="true" />
    </DxChart>
    <DxRangeSelector :data-source="dataSource" v-model:value="visualRange">
      <DxSize :height="120" />
      <DxRsChart>
        <DxRsValueAxis value-type="numeric" />
        <DxRsSeries
          type="line"
          value-field="open"
          argument-field="created_on"
          class="bg-gray-300"
        >
          <DxRsAggregation :enabled="true" />
        </DxRsSeries>
      </DxRsChart>
      <DxScale
        :placeholder-height="20"
        minor-tick-interval="day"
        tick-interval="month"
        value-type="datetime"
        aggregation-interval="week"
      />
      <DxBehavior :snap-to-ticks="false" call-value-changed="onMoving" />
    </DxRangeSelector>
  </div>
</template>
<script>
import axios from "axios";
import DxChart, {
  DxSeries,
  DxAggregation,
  DxArgumentAxis,
  DxGrid,
  DxLabel,
  DxValueAxis,
  DxMargin,
  DxLegend,
  DxTooltip,
} from "devextreme-vue/chart";

import DxRangeSelector, {
  DxSize,
  DxScale,
  DxChart as DxRsChart,
  DxValueAxis as DxRsValueAxis,
  DxSeries as DxRsSeries,
  DxAggregation as DxRsAggregation,
  DxBehavior,
} from "devextreme-vue/range-selector";

export default {
  components: {
    DxChart,
    DxSeries,
    DxAggregation,
    DxArgumentAxis,
    DxGrid,
    DxLabel,
    DxValueAxis,
    DxMargin,
    DxLegend,
    DxTooltip,
    DxRangeSelector,
    DxSize,
    DxScale,
    DxRsChart,
    DxRsValueAxis,
    DxRsSeries,
    DxRsAggregation,
    DxBehavior,
  },
  data() {
    return {
      seila1: [],
      id_stock: "",
      dataSource: [],
      visualRange: [],
    };
  },
  // created() {
  //   this.Grafico();
  //   this.FindStock();
  // },
  methods: {
    async FindStock() {
      if (this.$root.authenticated) {
        this.claims = await this.$auth.getUser();
        let accessToken = this.$auth.getAccessToken();
        try {
          let response = await axios.get(
            `http://localhost:8082/stocks/${this.name}`,

            {
              headers: { Authorization: "Bearer " + accessToken },
            }
          );
          this.seila1 = response.data;
          this.id_stock = this.seila1[0].id_Stock;
          console.log("olha pra baixo");
          console.log(this.seila1);
        } catch (error) {
          this.seila1 = `${error}`;
        }
      }
    },
    async Grafico() {
      this.claims = await this.$auth.getUser();
      let accessToken = this.$auth.getAccessToken();
      console.log(`Authorization: Bearer ${accessToken}`);
      try {
        let response = await axios.get(`http://localhost:8082/grafico/1`, {
          headers: { Authorization: "Bearer " + accessToken },
        });

        this.dataSource = response.data;
        console.log(this.dataSource);
      } catch (error) {
        this.dataSource = `${error}`;
      }
    },
  },
};
</script>
<style>
#chart-demo {
  height: 450px;
}

#zoomedChart {
  height: 315px;
  margin: 0 0 15px;
}

#chart-demo > div:not(#zoomedChart) {
  height: 120px;
}
</style>
