(ns rf-mater.views
  (:require [re-frame.core :as re-frame]
            [rf-mater.subs :as subs]
            ;; [cljsjs.material-ui]
            ;; [cljs-react-material-ui.core :refer [get-mui-theme color]]
            ;; [cljs-react-material-ui.reagent :as ui]
            ;; [cljs-react-material-ui.icons :as ic]
            ;; [garden.core :refer [css]]
            [reagent.core :as r]
          ;;["" :default ]
            ;
            ["@material-ui/core/AppBar" :default AppBar]
            ["@material-ui/core/Avatar" :default Avatar]

            ["@material-ui/core/Button" :default Button]

            ["@material-ui/core/Card" :default Card]
            ["@material-ui/core/CardActions" :default CardActions]
            ["@material-ui/core/CardContent" :default CardContent]
            ["@material-ui/core/CardMedia" :default CardMedia]
            ["@material-ui/core/CardHeader" :default CardHeader]
            ["@material-ui/core/Collapse" :default Collapse]

            ["@material-ui/core/Divider" :default Divider]

            ["@material-ui/core/Grid" :default Grid]

            ["@material-ui/core/Hidden" :default Hidden]

            ["@material-ui/core/Paper" :default Paper]

            ["@material-ui/core/IconButton" :default IconButton]
            ["@material-ui/core/Toolbar" :default Toolbar]
            ["@material-ui/core/Typography" :default Typography]
            ["@material-ui/core/styles" :refer [MuiThemeProvider createMuiTheme]]

            ["@material-ui/icons/Favorite" :default FavoriteIcon]
            ["@material-ui/icons/Share" :default ShareIcon]
            ["@material-ui/icons/ExpandMore" :default ExpandMoreIcon]
            ["@material-ui/icons/MoreVert" :default MoreVertIcon]
            ["@material-ui/icons/Menu" :default MenuIcon]
            ["@material-ui/icons/HelpOutline" :default HelpOutlineIcon]
            ))

;;
(def theme (createMuiTheme #js {}))
(def set-new-font
      "\"-apple-system\", \"BlinkMacSystemFont\", \"Segoe UI\",\"Roboto\",  \"Helvetica Neue\", \"Arial\", \"sans-serif\", \"Apple Color Emoji\", \"Segoe UI Emoji\", \"Segoe UI Symbol\""
      )
(set! (-> theme .-typography .-fontSize) 24)
(set! (-> theme .-typography .-body2 .-fontSize) "1rem")
(set! (-> theme .-typography .-body1 .-fontSize) "1rem")
(set! (-> theme .-typography .-body2 .-fontFamily) set-new-font)
(set! (-> theme .-typography .-body1 .-fontFamily) set-new-font)
(defn print-typo [] (js/console.log (-> theme .-typography)))

(def styles {:root {:flex-grow "1"
                    :margin-bottom "20px"}
             :flex {:flex "1"}
             :menu-button {:margin-left "-12px"
                           :margin-right "20px"}
             :cont-center {:display "flex"
					                 :justify-content "center"
					                 :width "100%"}
             :card {:width "99%"
                    :margin-top "10px"
                    }
             :media {:height "0px"
                     :padding-top "56.25%"}
             :actions {:display "flex"}
             :expand {:margin-left "auto"
                      ; :transform "rotate(0deg)"
                      ; :transition
                       }
             :avatar {:background-color "red"}
             :paper {;:height "200px"
                     ;:width "100%"
                     ;:min-width "200px"
                     ;:flex-basis "0"
                     ;:flex-grow "1"
                     ;:background-color "red"
                     :text-align "left"
                     :padding (* 2 (-> theme .-spacing .-unit))
                     :color (-> theme .-palette .-text .-secondary)
                     :background-color (-> theme .-palette .-primary .-light)
                     }
             :contein-temp {;:background-color (-> theme .-palette .-primary .-light)
                            :height "100px"
                            :width "100%"
                            }

             })

(defn info-block-main []
  (let []
    [:> Grid {:container true
              :spacing 8
              :style {:display "flex" :justify-content "space-between"}} ;;main information block: when&where
			[:> Grid {:item true :xs 12 :sm 6 :md 4
                :style {:padding "10px 0px 10px 20px"}} ;; information  when?
				[:> Typography {:color "textSecondary" :variant "title" :align "left" :gutterBottom true} "kiedy?"]
				[:> Typography {:color "primary" :variant "headline"} "25-01-2018"]
				[:> Typography {:color "primary" :variant "subheading"} "poniedziałek"]
				[:> Typography {:color "secondary" :variant "subheading"} "za 6 d."]]
			[:> Hidden {:xlDown true}]
			[:> Grid {:item true :xs 12 :sm 6 :md 4
                :style {:display "flex"
	 										  :flex-direction "column"
	 										  :justify-content "flex-start"
	 										  :padding "10px 20px 10px 0px"}} ;; information  where?
				[:> Typography {:color "textSecondary" :variant "title" :align "right" :gutterBottom true} "dokąd?"]
				[:> Typography {:color "primary" :variant "display1" :align "right"  :style {:flex-grow 2}} "Jańskie Łaźnie"]
				[:> Typography {:variant "button" :align "right" :style {:color (-> theme .-palette .-text .-primary)}}
          [:a {:href ""} "mapa"]]
			 ]]))

(defn info-block-about []
  (let [
        loc-grids {:el-01 {:xs 6 :sm 2 :md 2 :lg 1}
                   :el-02 {:xs 5 :sm 1 :md 1 :lg 1}
                   :el-03 {:xs 1 :sm 1 :md 1 :lg 1 :align "center"}
                   :el-04 {:xs 0 :sm 1 :md 1 :lg 1}
                   :el-05 {:xs 12 :sm 6 :md 4 :lg 2}}
        text-format {:form-01 {:color "default" :variant "body2" :style {:padding-left "10px"}}
                     :form-02 {:color "primary" :variant "subheading"}
                     :form-03 {:color "default" :variant "body1" :style {:padding-left "10px"}}}
        conten-format {:cont-form {:container true :spacing 8 :style {:margin-bottom "20px"}}}]
               [:> Grid {:container true} ;; second information block
                [:> Grid (conj {} (:cont-form conten-format));; info about time and place of start
                   [:> Grid (conj {:item true} (:el-01 loc-grids))
                     [:> Typography (conj {} (:form-01 text-format)) "wyjazd"]]

                   [:> Grid (conj {:item true} (:el-02 loc-grids))
                     [:> Typography (conj {} (:form-02 text-format)) "6:00"]]

                   [:> Grid (conj {:item true} (:el-03 loc-grids))
                     [:> HelpOutlineIcon]]
                   [:> Grid (conj {:item true} (:el-04 loc-grids))]
                   [:> Grid (conj {:item true} (:el-05 loc-grids))
                     [:> Typography (conj {} (:form-03 text-format))  "McD Factory (Wrocław) "
                      [:a {:href ""} "mapa"]]]]

            		 [:> Grid (conj {} (:cont-form conten-format)) ;; info about time and place of return
                   [:> Grid (conj {:item true} (:el-01 loc-grids))
                     [:> Typography (conj {} (:form-01 text-format)) "powrot"]]

                   [:> Grid (conj {:item true} (:el-02 loc-grids))
                     [:> Typography (conj {} (:form-02 text-format)) "20:00"]]

                   [:> Grid (conj {:item true} (:el-03 loc-grids))
                     [:> HelpOutlineIcon]]
                   [:> Grid (conj {:item true} (:el-04 loc-grids))]
                   [:> Grid (conj {:item true} (:el-05 loc-grids))
                     [:> Typography (conj {} (:form-03 text-format)) "McD Factory (Wrocław) "
                       [:a {:href ""} "mapa"]]]]

            		 [:> Grid (conj {} (:cont-form conten-format)) ;; info about road time&distance
                   [:> Grid (conj {:item true} (:el-01 loc-grids))
                      [:> Typography (conj {} (:form-01 text-format)) "w drodze"]]

                   [:> Grid (conj {:item true} (:el-02 loc-grids))
                      [:> Typography (conj {} (:form-02 text-format)) "2,5 h"]]

                   [:> Grid (conj {:item true} (:el-03 loc-grids))
                      [:> HelpOutlineIcon]]
                   [:> Grid (conj {:item true} (:el-04 loc-grids))]
                   [:> Grid (conj {:item true} (:el-05 loc-grids))
                      [:> Typography (conj {} (:form-03 text-format)) "odległoć 150 km" ]]]

          		   [:> Grid (conj {} (:cont-form conten-format)) ;; info about staeing on slop
                   [:> Grid (conj {:item true} (:el-01 loc-grids))
                     [:> Typography (conj {:style {:padding-left "10px"}} (:form-01 text-format)) "na stoku"]]

                   [:> Grid (conj {:item true} (:el-02 loc-grids))
                     [:> Typography (conj {} (:form-02 text-format)) "8 h"]]

                   [:> Grid (conj {:item true} (:el-03 loc-grids))
                     [:> HelpOutlineIcon]]]
               ]
              ))

(defn event-card []
  [:div {:style (:cont-center styles)}
   [:> Card {:style (:card styles)}
     [:> CardContent
       [:div {:style (:root styles)}
			   [:> Grid {:container true :spacing 16}
           [info-block-main]
           [:> Divider { :light false  :style {:width "100%" :margin "10px 0px 20px 0px"}}]
           [info-block-about]


           [:> Divider { :light false  :style {:width "100%" :margin "20px 0px 20px 0px"}}]

           [:> Grid {:container true}
         		 [:> Grid {:item true :xs 12 :lg 5}
               [:div {:style (:contein-temp styles)} "osoba kontaktowa"]]]

           [:> Divider { :light false  :style {:width "100%" :margin "20px 0px 20px 0px"}}]

			     [:> Grid {:container true}
         		 [:> Grid {:item true :xs 12 :md 6}
               [:div {:style (:contein-temp styles)} "opis samochod"]]
             [:> Grid {:item true :xs 12 :md 6}
               [:div {:style (:contein-temp styles)} "foto somochod"]]]

           [:> Divider { :light false  :style {:width "100%" :margin "20px 0px 20px 0px"}}]

           [:> Grid {:container true} ;; list of passengers information block
         		 [:> Grid {:container true :spacing 0 :style {}} ;; info about Jacek
               [:> Grid {:item true :xs 12 :sm 6 :md 3}
                 [:div {:style (:contein-temp styles)} "Jacek"]]
               [:> Grid {:item true :xs 12 :sm 6 :md 3}
                 [:div {:style (:contein-temp styles)} "kierowca"]]
               [:> Grid {:item true :xs 12 :sm 12 :md 6}
                 [:div {:style (:contein-temp styles)} "potwierdzono"]]]
             [:> Divider { :light false :inset true :style {:width "100%"}}]

         		 [:> Grid {:container true :spacing 0 :style {}} ;; info about Zofia
               [:> Grid { :item true :xs 12 :sm 6 :md 3 :style {:display "flex" :flex-direction "row"}}
                 [:> Avatar "Z"]
                 [:div {:style (:contein-temp styles)} "Zofia"]]
               [:> Grid {:item true :xs 12 :sm 6 :md 3}
                 [:div {:style (:contein-temp styles)} "pasażer"]]
               [:> Grid {:item true :xs 12 :sm 12 :md 6}
                 [:div {:style (:contein-temp styles)} "potwierdzono"]]]
             [:> Divider { :light false :inset true :style {:width "100%"}}]

         		 [:> Grid {:container true :spacing 0 :style {}} ;; info about Hania
               [:> Grid {:item true :xs 12 :sm 6 :md 3}
                 [:div {:style (:contein-temp styles)} "Hania"]]
               [:> Grid {:item true :xs 12 :sm 6 :md 3}
                 [:div {:style (:contein-temp styles)} "pasażer"]]
               [:> Grid {:item true :xs 12 :sm 12 :md 6}
                 [:div {:style (:contein-temp styles)} "nie potwierdzono"]]]
             [:> Divider { :light false :inset true :style {:width "100%"}}]
         		 [:> Grid {:container true :spacing 0 :style {}} ;; info about Olek
               [:> Grid {:item true :xs 12 :sm 6 :md 3}
                 [:div {:style (:contein-temp styles)} "Olek"]]
               [:> Grid {:item true :xs 12 :sm 6 :md 3}
                 [:div {:style (:contein-temp styles)} "pasażer"]]
               [:> Grid {:item true :xs 12 :sm 12 :md 6}
                 [:div {:style (:contein-temp styles)} "zaproszono"]]]
             [:> Divider { :light false :inset true :style {:width "100%"}}]

             [:> Grid {:container true :spacing 0 :style {}} ;; input fild new-passenger
               [:> Grid {:item true :xs 12}
                 [:div {:style (:contein-temp styles)} "dodawanie pasażera"]]]
            ]]]





       [:> Typography {:component "p"}
         "This impressive paella is a perfect party dish and a fun meal to cook together
 with your guests. Add 1 cup of frozen peas along with the mussels, if you like."]]
     [:> CardActions {:style (:actions styles)
                      :disable-action-spacing false
                      }
        [:> IconButton {:aria-label "Add to favorites"}
          [:> FavoriteIcon]]
        [:> IconButton {:aria-label "Share"}
          [:> ShareIcon]]
        [:> IconButton {:aria-label "Show more"
                        :style (:expand styles)
                        ;:on-click
                        ;:aria-expanded
                        }
          [:> ExpandMoreIcon]]]
     [:> Collapse {:in true}
       [:> CardContent
         [:> Typography {;:paragraph ""
                         :variant "body2"}
           "Method:"]
         [:> Typography {;:paragraph true
                         }
           "Heat 1/2 cup of the broth in a pot until simmering, add saffron and set aside
 for 10 minutes."]
         [:> Typography {;:paragraph true
                         }
           "Heat oil in a (14- to 16-inch) paella pan or a large, deep skillet over medium-high
                heat. Add chicken, shrimp and chorizo, and cook, stirring occasionally until lightly
                browned, 6 to 8 minutes. Transfer shrimp to a large plate and set aside, leaving
                chicken and chorizo in the pan. Add pimentón, bay leaves, garlic, tomatoes, onion,
                salt and pepper, and cook, stirring often until thickened and fragrant, about 10
                minutes. Add saffron broth and remaining 4 1/2 cups chicken broth; bring to a boil."]
         [:> Typography {;:paragraph true
                         }
           "Add rice and stir very gently to distribute. Top with artichokes and peppers, and
                cook without stirring, until most of the liquid is absorbed, 15 to 18 minutes.
                Reduce heat to medium-low, add reserved shrimp and mussels, tucking them down into
                the rice, and cook again without stirring, until mussels have opened and rice is
                just tender, 5 to 7 minutes more. (Discard any mussels that don’t open.)"]
         [:> Typography
           "Set aside off of the heat to let rest for 10 minutes, and then serve."]
        ]]
    ]])

(defn app-bar []
        [:> AppBar {:position "static"}
	        [:> Toolbar
	          [:> IconButton {:style (:menu-button styles)
	                          :color "inherit"
	                          :aria-label "Menu"}
	            [:> MenuIcon]]
	          [:> Typography {:variant "title"
	                          :color "inherit"
	                          :style (:flex styles)}
	            "Razem Na Stok"]
	          [:> Button {:color "inherit"}
	            "Login"]]
	       ])

(defn main-panel []
  [:> MuiThemeProvider (do
                         (js/console.log (-> theme .-typography))
                         (conj {} {:theme theme}))
    [:div {:style (:root styles)}

      [app-bar]
    	[event-card]

]])






;; (defn destination-card []
;;   (let []
;;     (fn []
;;       [ui/card {:style {:margin "10px 0px"}}

;;          [:div.destination {:style {:padding "5px"
;;                         :display "flex"
;;                         :justify-content "space-between"
;;                        :align-items "center"}}

;;           [ui/card-title {:title "Jańskie Łaźnie"
;;                           :subtitle "miejsce docelowe"
;;                           :style {:padding "5px"}}]

;;           [ui/raised-button {:label "negocjacja"
;;                               :primary true
;;                               :disable false}]]

;;         [:div.day {:style {:padding "5px"
;;                        :display "flex"
;;                        :justify-content "space-between"
;;                        :align-items "center"}}

;;           [ui/card-title {:title "sobota, 14-04-18"
;;                           :subtitle "dzień wyjazdu"
;;                           :style {:padding "5px"
;;                                    :font-size "20px"}}]

;;           [ui/raised-button {:label "negocjacja"
;;                              :primary true
;;                              :disable false}]]
;;         [ui/divider]
;;         [ui/card-text
;;           [ui/table
;;             [ui/table-body {:display-row-checkbox false}
;;               [ui/table-row
;;                 [ui/table-row-column "odległosc"]
;;                  [ui/table-row-column "150km"]
;;               ]
;;               [ui/table-row
;;                 [ui/table-row-column "w drodze"]
;;                  [ui/table-row-column "2,5h"]
;;               ]
;;               [ui/table-row
;;                 [ui/table-row-column "wyjazd"]
;;                  [ui/table-row-column "7:00"]
;;               ]
;;               [ui/table-row
;;                 [ui/table-row-column "na stoku"]
;;                  [ui/table-row-column "8h"]
;;               ]
;;               [ui/table-row
;;                 [ui/table-row-column "powrot"]
;;                  [ui/table-row-column "18:00"]
;;               ]]]]
;;        ])))

;; (defn avatarN []
;;   [ui/avatar "2"])

;; (defn tabel-row-passenger [])


;; (defn passenger-entry []
;;   (let [pas-name (r/atom "")]
;;     (fn []
;;       [:div {:style {:padding "5px"
;;                      :display "flex"
;;                      :justify-content "space-between"
;;                       :align-items "center"}}
;;                   [ui/text-field {:hint-text "wpisz imię"
;;                                   :floating-label-text "pasażer 3"
;;                                   :type "text"
;;                                   :value @pas-name
;;                                   :on-change #(reset! pas-name (-> % .-target .-value))
;;                                   ; :on-save #(when (seq %)
;;                                   ;             (re-frame/dispatch [:add-passenger %]))
;;                                   :on-save (fn [args] (js/console.log args))
;;                                   }]
;;                   [ui/floating-action-button {:mini true
;;                                               :primary true
;;                                               :on-click #(when (seq @pas-name)
;;                                                              (re-frame/dispatch [:add-passenger @pas-name]))}
;;                     [ic/content-add]]])))

;; (defn person-view [name status]
;;   [ui/table-row
;; 		[ui/table-row-column name]
;; 		 [ui/table-row-column status]])

;; (defn cards-with-passangers []
;;  (let [driver @(re-frame/subscribe [:driver])
;;        passengers @(re-frame/subscribe [:passengers])]
;;           [ui/card-text
;; 	          [ui/table ;{:display-row-checkbox false}
;; 	             [ui/table-header {:display-select-all false
;; 	                              :adjust-for-checkbox false}
;; 	              [ui/table-row
;; 	                [ui/table-header-column "imię"]
;; 	                [ui/table-header-column "status"]]]
;; 	            [ui/table-body {:display-row-checkbox false}
;; 	              [ui/table-row
;; 	                [ui/table-row-column (get driver :name)]
;; 	                 [ui/table-row-column "kierowca"]]
;; 								(map-indexed
;;                    (fn [idx person] [person-view (:name person)
;;                                      (str "pasażer " (inc idx))])
;;                   passengers)]]
;; 	           [passenger-entry]]))

;; (defn car-card []
;;   (let []
;;     (fn []
;;       [ui/card {:style {:margin "10px 0px"}}
;;         [:div.destination {:style {:padding "5px"
;;                         :display "flex"
;;                         :justify-content "space-between"
;;                        :align-items "center"}}
;;            [ui/card-title {:title "VW T4"
;;                           :subtitle (str "czerwony" ", " "Blueberry Machine" ", " "miejsc razem " "5")
;;                           :style {:padding "5px"}}]
;;            ;(avatarN)
;;           [ui/badge {:badge-content "3"
;;                      :primary true
;;                       :style {:display "flex"
;;                      ;:flex-grow "2"
;;                      :padding "12px 12px 12px 12px"}}
;;             [ui/avatar {:color (color :deepOrange300)
;;                         :backgroundcolor (color :purple500)
;;                         ;:size "80"
;;                         :margin "0px"
;;                         :children "2"
;;                          }
;;               ]]
;;           ]
;;         [ui/divider]
;; 				[cards-with-passangers]
;;        ])))




;; (defn home-panel []
;;   (let [name (re-frame/subscribe [::subs/name])]

;;      ;[:div [:h1 (str "Hello from " @name ". This is the Home Page.")]
;;      [ui/mui-theme-provider {:mui-theme (get-mui-theme
;;                                          ;(aget js/MaterialUIStyles "DarkRawTheme")
;;                                          )}
;;          [:div
;;            [app-bar]
;;            ;[jumbotron]

;;           [destination-card]
;;            [car-card]
;;           [:a {:href "#/about"} "go to About Page"]


;;         ]
;;       ]
;;      ))


;; ;; about

;; (defn about-panel []
;;   [:div "This is the About Page."
;;    [:div [:a {:href "#/"} "go to Home Page"]]])


;; ;; main

;; (defn- panels [panel-name]
;;   (case panel-name
;;     :home-panel [home-panel]
;;     :about-panel [about-panel]
;;     [:div]))

;; (defn show-panel [panel-name]
;;   [panels panel-name])

;; (defn main-panel []
;;   (let [active-panel (re-frame/subscribe [::subs/active-panel])]
;;     [show-panel @active-panel]))
