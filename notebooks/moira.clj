(ns moira
  {:nextjournal.clerk/visibility {:code :hide :result :show}}
  (:require [nextjournal.clerk :as clerk]
            [meta-csv.core :as csv]
            [tablecloth.api :as tc]))

;; # Official WHO data on newborn growth
;; Source: https://www.who.int/tools/child-growth-standards/standards/

;; ## Weight
(let [expected-weight (tc/dataset (csv/read-csv "notebooks/weight-zscore.csv"))
      week (:Week expected-weight)
      moira [2.640 nil  2.690 2.770 2.960 3.120 3.250 3.320 3.770]]
  (clerk/plotly {:data [{:x week :y (into [] (:SD0 expected-weight)) :type "scatter" :mode "lines" :name "Median"}
                        {:x week :y (into [] (:SD1neg expected-weight)) :type "scatter" :mode "lines" :name "SD -1"}
                        {:x week :y (into [] (:SD2neg expected-weight)) :type "scatter" :mode "lines" :name "SD -2"}
                        {:x week :y (into [] (:SD3neg expected-weight)) :type "scatter" :mode "lines" :name "SD -3"}
                        {:x week :y moira :type "scatter" :mode "markers" :name "Moira" :marker {:size 7 :color "#666"}}]
                 :layout {:title "Z-score for weight-for-age"
                          :xaxis {:title "Weeks"}
                          :yaxis {:title "Weight (kg)"}}}))

(let [expected-weight (tc/dataset (csv/read-csv "notebooks/weight-percentiles.csv"))
      week (:Week expected-weight)
      moira [2.640 nil 2.690 2.770 2.960 3.120 3.250 3.320 3.770]]
  (clerk/plotly {:data [{:x week :y (into [] (:P50 expected-weight)) :type "scatter" :mode "lines" :name "50"}
                        {:x week :y (into [] (:P10 expected-weight)) :type "scatter" :mode "lines" :name "10"}
                        {:x week :y (into [] (:P5 expected-weight)) :type "scatter" :mode "lines" :name "5"}
                        {:x week :y (into [] (:P3 expected-weight)) :type "scatter" :mode "lines" :name "3"}
                        {:x week :y (into [] (:P1 expected-weight)) :type "scatter" :mode "lines" :name "1"}
                        {:x week :y (into [] (:P01 expected-weight)) :type "scatter" :mode "lines" :name "0.1"}
                        {:x week :y moira :type "scatter" :mode "markers" :name "Moira" :marker {:size 7 :color "#666"}}]
                 :layout {:title "Percentile for weight-for-age"
                          :xaxis {:title "Weeks"}
                          :yaxis {:title "Weight (kg)"}}}))
;; ## Height
(let [expected-weight (tc/dataset (csv/read-csv "notebooks/height.csv"))
      week (:Week expected-weight)
      moira [48 48.5 50 51.5 nil nil nil 52.5]]
  (clerk/plotly {:data [{:x week :y (into [] (:SD0 expected-weight)) :type "scatter" :mode "lines" :name "Median"}
                        {:x week :y (into [] (:SD1neg expected-weight)) :type "scatter" :mode "lines" :name "SD -1"}
                        {:x week :y (into [] (:SD2neg expected-weight)) :type "scatter" :mode "lines" :name "SD -2"}
                        {:x week :y moira :type "scatter" :mode "markers" :name "Moira" :marker {:size 7 :color "#666"}}]
                 :layout {:title "Z-score for height-for-age"
                          :xaxis {:title "Weeks"}
                          :yaxis {:title "Height (cm)"}}}))

;; ## Head circumference
(let [expected-weight (tc/dataset (csv/read-csv "notebooks/head.csv"))
      week (:Week expected-weight)
      moira [nil 34 35 35 nil nil 36 38]]
  (clerk/plotly {:data [{:x week :y (into [] (:SD0 expected-weight)) :type "scatter" :mode "lines" :name "Median"}
                        {:x week :y (into [] (:SD1neg expected-weight)) :type "scatter" :mode "lines" :name "SD -1"}
                        {:x week :y (into [] (:SD2neg expected-weight)) :type "scatter" :mode "lines" :name "SD -2"}
                        {:x week :y moira :type "scatter" :mode "markers" :name "Moira" :marker {:size 7 :color "#666"}}]
                 :layout {:title "Z-score for height-for-age"
                          :xaxis {:title "Weeks"}
                          :yaxis {:title "Height (cm)"}}}))

